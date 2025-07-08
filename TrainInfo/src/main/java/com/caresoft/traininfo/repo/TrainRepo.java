package com.caresoft.traininfo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.caresoft.traininfo.model.Train;

@Repository
public interface TrainRepo extends MongoRepository<Train, String>{

}
