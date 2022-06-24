package com.tp.yogioteur.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomTypeDTO {
	
	private Long rtNo;
	private String rtType;
	private Integer rtMax;
	
}
