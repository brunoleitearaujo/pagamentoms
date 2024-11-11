package com.baraujo.pagamentoms.controller;

import com.baraujo.pagamentoms.controller.dto.CarteiraDto;
import com.baraujo.pagamentoms.entity.Carteira;
import com.baraujo.pagamentoms.service.CarteiraService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarteiraController {

    @Autowired
    private CarteiraService service;

    @PostMapping("/carteira")
    public ResponseEntity<Carteira> createCarteira(@RequestBody @Valid CarteiraDto dto) {
        var carteira = service.createCarteira(dto);
        return ResponseEntity.ok(carteira);
    }
}
