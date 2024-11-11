package com.baraujo.pagamentoms.service;

import com.baraujo.pagamentoms.client.AuthorizationClient;
import com.baraujo.pagamentoms.controller.dto.TransferirDto;
import com.baraujo.pagamentoms.entity.Transferir;
import com.baraujo.pagamentoms.exception.CarteiraException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferirDto transferir) {
        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new CarteiraException();
        }

        return resp.getBody().authorized();
    }
}
