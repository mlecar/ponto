package com.mlc.ponto.boundary.rest;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeTrackingRecordRepository extends MongoRepository<TimeTrackingRecord, Long> {

    public List<TimeTrackingRecord> findByDay(int day);
}
