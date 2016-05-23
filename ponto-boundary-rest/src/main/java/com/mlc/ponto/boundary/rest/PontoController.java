package com.mlc.ponto.boundary.rest;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    @Autowired
    private TimeTrackingRecordRepository repository;

    @ResponseBody
    @RequestMapping(value = { "/{userId}/add", "/{userId}/add/" }, method = RequestMethod.PUT, produces = "application/json")
    public String add(HttpServletRequest request, @Valid DateTimeForm addedDateTime) throws Exception {
        try {
            repository.save(new TimeTrackingRecord(addedDateTime.getDay(), addedDateTime.getMonth(), addedDateTime.getYear(), addedDateTime.getHour(), addedDateTime.getMinute()));

            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(repository.findByDay(addedDateTime.getDay()));

        } catch (Exception e) {
            throw e;
        }
    }

}
