package com.caresoft.traininfo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caresoft.traininfo.model.Train;
import com.caresoft.traininfo.repo.TrainRepo;

@Service
public class TrainService {
	
	@Autowired
	private TrainRepo repo;
	
	public List<Train> getAllTrains() {
		
		return repo.findAll();
		
	}
	
	public String addTrains(List<Train> trains) {
		
		List<Train> response = repo.saveAll(trains);
		if(response!=null) {
			return "success";
		} 
		return "failed to add data";	
	}
	
	public Optional<Train> getTrainById(String trainId) {
	    return repo.findById(trainId);
	}
	
	public List<Train> findTrainsBetween(String from, String to) {
	    return repo.findAll().stream()
	        .filter(train -> {
	            List<String> stationList = new ArrayList<>(train.getStations().keySet());
	            int fromIndex = stationList.indexOf(from);
	            int toIndex = stationList.indexOf(to);
	            return fromIndex >= 0 && toIndex > fromIndex;
	        })
	        .collect(Collectors.toList());
	}


	
}
