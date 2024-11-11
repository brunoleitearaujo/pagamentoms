package com.baraujo.pagamentoms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferirParaTipoCarteiraException extends CarteiraException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("O tipo de carteira não tem permissão para transferir");

        return pd;
    }
}
