package com.caresoft.traininfo.model;

import java.util.Map;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Station {
	
	@Id
    private String stationName;

    private Map<String, TrainMeta> trains;

}
