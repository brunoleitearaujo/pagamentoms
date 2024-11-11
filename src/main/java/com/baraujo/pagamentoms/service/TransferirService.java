package com.baraujo.pagamentoms.service;

import com.baraujo.pagamentoms.controller.dto.TransferirDto;
import com.baraujo.pagamentoms.entity.Carteira;
import com.baraujo.pagamentoms.entity.Transferir;
import com.baraujo.pagamentoms.exception.CarteiraNotFoundException;
import com.baraujo.pagamentoms.exception.SaldoInsuficienteException;
import com.baraujo.pagamentoms.exception.TransferenciaNotAuthorizedException;
import com.baraujo.pagamentoms.exception.TransferirParaTipoCarteiraException;
import com.baraujo.pagamentoms.repository.CarteiraRepository;
import com.baraujo.pagamentoms.repository.TranferirRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TransferirService {

    @Autowired
    private AuthorizationService authorizationService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private TranferirRepository tranferirRepository;

    @Autowired
    private CarteiraRepository carteiraRepository;

    @Transactional
    public Transferir transferir(TransferirDto transferirDto) {
        var remetente = carteiraRepository.findById(transferirDto.remetente())
                .orElseThrow(() -> new CarteiraNotFoundException(transferirDto.remetente()));

        var receptor = carteiraRepository.findById(transferirDto.receptor())
                .orElseThrow(() -> new CarteiraNotFoundException(transferirDto.receptor()));

        validateTransferir(transferirDto, remetente);

        remetente.debitar(transferirDto.valor());
        receptor.creditar(transferirDto.valor());

        var transferir = new Transferir(remetente, receptor, transferirDto.valor());

        carteiraRepository.save(remetente);
        carteiraRepository.save(receptor);

        var tr = tranferirRepository.save(transferir);

        CompletableFuture.runAsync(() -> notificationService.sendNotification(tr));

        return tr;
    }

    private void validateTransferir(TransferirDto transferirDto, Carteira remetente) {
        if (!remetente.isTransferirParaTipoCarteira()) {
            throw new TransferirParaTipoCarteiraException();
        }

        if (!remetente.isSaldoDisponivel(transferirDto.valor())) {
            throw new SaldoInsuficienteException();
        }

        if (!authorizationService.isAuthorized(transferirDto)) {
            throw new TransferenciaNotAuthorizedException();
        }
    }
}
