package com.caresoft.traininfo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.caresoft.traininfo.model.StationMeta;
import com.caresoft.traininfo.model.Train;
import com.caresoft.traininfo.service.TrainService;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@CrossOrigin(origins = "*")
public class TrainDataController {
	
	@Autowired
	private TrainService trainService;
	
	@PostMapping("/addTrains")
	public ResponseEntity<String> addTrains(@RequestBody Map<String, Map<String, StationMeta>> trainData) {
	    List<Train> trainSchedules = trainData.entrySet().stream()
	        .map(entry -> {
	            Train schedule = new Train();
	            schedule.setId(entry.getKey());
	            schedule.setStations(entry.getValue());
	            return schedule;
	        })
	        .collect(Collectors.toList());

	    trainService.addTrains(trainSchedules);
	    return ResponseEntity.ok(trainSchedules.size() + " trains added successfully.");
	}


	
	@GetMapping("/trains")
	public List<String> getAllTrainIds() {
	    return trainService.getAllTrains().stream()
	            .map(Train::getId)
	            .collect(Collectors.toList());
	}

	@GetMapping("/trains/{trainId}")
	public ResponseEntity<Train> getTrainSchedule(@PathVariable String trainId) {
	    return trainService.getTrainById(trainId)
	            .map(ResponseEntity::ok)
	            .orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/search")
    public List<Train> findTrainsBetween(@RequestParam String from, @RequestParam String to) {
        return trainService.findTrainsBetween(from, to);
    }
	
}
