package com.caresoft.traininfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caresoft.traininfo.model.Station;
import com.caresoft.traininfo.repo.StationRepo;

@Service
public class StationService {

	@Autowired
    private StationRepo stationRepo;

    public String addStations(List<Station> stations) {
        List<Station> saved = stationRepo.saveAll(stations);
        return saved.size() + " stations added.";
    }
    
    public Optional<Station> getStationByName(String name) {
        return stationRepo.findById(name);
    }


    public List<Station> getAllStations() {
        return stationRepo.findAll();
    }
    
}
