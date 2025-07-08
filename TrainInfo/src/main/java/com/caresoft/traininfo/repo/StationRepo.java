package com.caresoft.traininfo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caresoft.traininfo.model.Station;

@Repository
public interface StationRepo extends MongoRepository<Station, String> {
}
