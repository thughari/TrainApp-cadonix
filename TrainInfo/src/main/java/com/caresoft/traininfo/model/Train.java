package com.caresoft.traininfo.model;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Train {
	
	@Id
	private String id;
	
	private Map<String, StationMeta> stations;
	
}
