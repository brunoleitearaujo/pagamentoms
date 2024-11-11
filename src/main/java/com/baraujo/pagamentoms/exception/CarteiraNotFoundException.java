package com.baraujo.pagamentoms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class CarteiraNotFoundException extends CarteiraException{

    private Long id;

    public CarteiraNotFoundException(Long id) {
        this.id = id;
    }

    @Override
    public ProblemDetail toProblemDetail() {
        var pd = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pd.setTitle("Carteira não encontrada");
        pd.setDetail("Não há carteira com id " + id + ".");

        return pd;
    }
}
