package com.tp.yogioteur.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomDTO {
	
	private Long roomNo;
	private Long rtNo;
	private String roomName;
	private Integer roomStatus;
	private Date roomCheckIn;
	private Date roomCheckOut;
	private Integer roomPrice;
	
	private RoomTypeDTO roomTypeDTO;
	
	
}
