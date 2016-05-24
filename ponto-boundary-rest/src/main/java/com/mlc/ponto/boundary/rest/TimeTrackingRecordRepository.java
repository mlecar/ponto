package com.mlc.ponto.boundary.rest;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TimeTrackingRecordRepository extends MongoRepository<TimeTrackingRecord, String> {

    public TimeTrackingRecord findById(String id);
}
