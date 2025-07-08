package com.caresoft.traininfo.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StationMeta {
	
	private List<String> days;
    private String arrival;
    private String departure;
    private String day;
}
