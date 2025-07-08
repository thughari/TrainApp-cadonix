package com.caresoft.traininfo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.caresoft.traininfo.model.Station;
import com.caresoft.traininfo.model.TrainMeta;
import com.caresoft.traininfo.service.StationService;

@RestController
@CrossOrigin(origins = "*")
public class StationDataController {
	@Autowired
    private StationService stationService;

    @PostMapping("/addStations")
    public ResponseEntity<String> addStations(@RequestBody Map<String, Map<String, TrainMeta>> stationData) {
        List<Station> stations = stationData.entrySet().stream()
            .map(entry -> new Station(entry.getKey(), entry.getValue()))
            .collect(Collectors.toList());

        String result = stationService.addStations(stations);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/stations")
    public List<String> getAllStationNames() {
        return stationService.getAllStations().stream()
                .map(Station::getStationName)
                .collect(Collectors.toList());
    }

    @GetMapping("/stations/{stationName}")
    public ResponseEntity<Station> getStationSchedule(@PathVariable String stationName) {
        return stationService.getStationByName(stationName)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
