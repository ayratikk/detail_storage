package com.example.detail_storage.common.exception;

import com.example.detail_storage.common.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.LazyInitializationException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.xml.bind.JAXBException;
import java.net.URISyntaxException;
import java.nio.file.AccessDeniedException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Logger;

@Component
@ControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = { //тут те исключения, которые он может отловить
            NullPointerException.class,
            ConstraintViolationException.class,
            SQLIntegrityConstraintViolationException.class,
            URISyntaxException.class,
            HttpClientErrorException.class,
            JAXBException.class,
            LazyInitializationException.class,
            RuntimeException.class,
            EntityNotFoundException.class,
            EntityExistsException.class,
            BadRequestException.class,
            AccessDeniedException.class,
    })

    ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        return buildErrorResult(Message.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<Object> buildErrorResult(Message message, HttpStatus httpStatus, Exception ex) {
        if(ex != null){
            log.error(ex.getMessage(),ex);
        }
        if(message == null){
            message = Message.INTERNAL_SERVER_ERROR;
        }


        return null;

    }
}
