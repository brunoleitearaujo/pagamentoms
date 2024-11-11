package com.baraujo.pagamentoms.controller;

import com.baraujo.pagamentoms.controller.dto.TransferirDto;
import com.baraujo.pagamentoms.entity.Transferir;
import com.baraujo.pagamentoms.service.TransferirService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransferirController {

    @Autowired
    TransferirService service;

    @PostMapping("/transferir")
    public ResponseEntity<Transferir> transferir(@RequestBody @Valid TransferirDto dto) {
        var resp = service.transferir(dto);
        return ResponseEntity.ok(resp);
    }
}
