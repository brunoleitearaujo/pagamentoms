package com.baraujo.pagamentoms.controller;

import com.baraujo.pagamentoms.exception.CarteiraException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.security.InvalidParameterException;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(CarteiraException.class)
    public ProblemDetail handleCarteiraException(CarteiraException e) {
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var fieldErros = e.getFieldErrors()
                .stream()
                .map(f -> new InvalidParam(f.getField(), f.getDefaultMessage()));

        var pd = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);

        pd.setTitle("Seus parâmetros de solicitação não foram validados");
        pd.setProperty("invalid-param", fieldErros);

        return pd;
    }

    private record InvalidParam(String nome, String causa){}
}
