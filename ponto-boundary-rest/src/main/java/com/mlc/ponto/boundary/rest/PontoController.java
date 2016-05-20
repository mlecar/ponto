package com.mlc.ponto.boundary.rest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    @ResponseBody
    @RequestMapping(value = { "/{userId}/add", "/{userId}/add/" }, method = RequestMethod.PUT, produces = "application/json")
    public String add(HttpServletRequest request, @Valid DateTimeForm addedDateTime) throws Exception {
        try {
            return addedDateTime.toString();

        } catch (Exception e) {
            throw e;
        }
    }

}
