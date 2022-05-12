package com.example.detail_storage.common.exception;

import org.hibernate.LazyInitializationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.xml.bind.JAXBException;
import java.net.URISyntaxException;
import java.sql.SQLIntegrityConstraintViolationException;

public class ExceptionHandler extends ResponseEntityExceptionHandler{
    @org.springframework.web.bind.annotation.ExceptionHandler(value = { //тут те исключения, которые он может отловить
            NullPointerException.class,
            ConstraintViolationException.class,
            SQLIntegrityConstraintViolationException.class,
            URISyntaxException.class,
            HttpClientErrorException.class,
            JAXBException.class,
            LazyInitializationException.class,
            RuntimeException.class
    })
     ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        return buildErrorResult("INTERNAL_SERVER_ERROR",HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }
    private ResponseEntity<Object> buildErrorResult(String message,HttpStatus httpStatus,Exception ex) {
        //добиши метод, который возвращает ответ в при возникновении исключения.
        return null;

    }
}
