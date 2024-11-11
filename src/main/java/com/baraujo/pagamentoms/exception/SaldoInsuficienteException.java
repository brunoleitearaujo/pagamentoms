package com.baraujo.pagamentoms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class SaldoInsuficienteException extends CarteiraException{

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Saldo insuficiente");
        pd.setDetail("Não foi possivel realizar a transferencia por falta de saldo");

        return pd;
    }
}
