package com.baraujo.pagamentoms.service;

import com.baraujo.pagamentoms.controller.dto.CarteiraDto;
import com.baraujo.pagamentoms.entity.Carteira;
import com.baraujo.pagamentoms.exception.CarteiraVerificarDadosExistentesException;
import com.baraujo.pagamentoms.repository.CarteiraRepository;
import org.springframework.stereotype.Service;

@Service
public class CarteiraService {

    private final CarteiraRepository repository;

    public CarteiraService(CarteiraRepository repository) {
        this.repository = repository;
    }

    public Carteira createCarteira(CarteiraDto dto) {

        var entity = repository.findByCpfCnpjOrEmail(dto.cpfCnpj(), dto.email());
        if (entity.isPresent()) {
            throw new CarteiraVerificarDadosExistentesException("CpfCnpj ou Email já existem");
        }

        return repository.save(dto.toCarteira());
    }
}
