package com.mlc.ponto.boundary.rest;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Object handleRestException(Exception e) throws IOException {
        log.warn("Exception nao capturada, avisar a equipe de DEV ASAP", e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>("Falha de processamento", headers, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseBody
    @ExceptionHandler({DuplicateKeyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Object badRequest(HttpServletRequest request, Exception e) throws IOException {
        log.warn("Requisicao invalida do ip " + request.getRemoteAddr(), e);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        return new ResponseEntity<String>("Falha de processamento", headers, HttpStatus.BAD_REQUEST);
    }
}
