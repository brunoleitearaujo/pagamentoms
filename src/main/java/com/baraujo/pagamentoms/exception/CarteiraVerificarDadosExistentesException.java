package com.baraujo.pagamentoms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraVerificarDadosExistentesException extends CarteiraException {

    private String detail;

    public CarteiraVerificarDadosExistentesException(String detail) {
        this.detail = detail;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Os dados da carteira já existem");
        pd.setDetail(detail);

        return pd;
    }
}
