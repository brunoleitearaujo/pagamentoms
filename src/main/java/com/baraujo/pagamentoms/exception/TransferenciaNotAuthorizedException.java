package com.baraujo.pagamentoms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferenciaNotAuthorizedException extends CarteiraException {

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Transferência não autorizada.");
        pd.setDetail("O serviço de autorização não autorizou esta transferência");

        return pd;
    }
}
