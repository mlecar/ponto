package com.mlc.ponto.boundary.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ponto")
public class PontoController {

    @Autowired
    private TimeTrackingRecordRepository repository;

    @ResponseBody
    @RequestMapping(value = { "/{userId}/add", "/{userId}/add/" }, method = RequestMethod.PUT, produces = "application/json")
    @ResponseStatus(code = HttpStatus.CREATED)
    public String add(@Valid DateTimeForm addedDateTime) throws Exception {
        try {
            TimeTrackingRecord record = repository.save(new TimeTrackingRecord(addedDateTime.getDay(), addedDateTime.getTime()));

            return record.toString();

        } catch (Exception e) {
            throw e;
        }
    }

    @ResponseBody
    @RequestMapping(value = { "/{userId}", "/{userId}" }, method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(code = HttpStatus.FOUND)
    public String list() throws Exception {
        try {
            StringBuffer sb = new StringBuffer();

            List<TimeTrackingRecord> lista = repository.findAll();
            for (TimeTrackingRecord record : lista) {
                sb.append(record.toString());
            }
            return sb.toString();

        } catch (Exception e) {
            throw e;
        }
    }

}
