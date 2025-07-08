package com.caresoft.traininfo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TrainMeta {

	private String arrival;
    private String deprature;
    private List<String> days;
    
}
