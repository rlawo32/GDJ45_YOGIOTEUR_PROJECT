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
public class ReservationDTO {

	private String reserNo;
	private Long memberNo;
	private Long roomNo;
	private Long nonNo;
	private Date reserCheckin;
	private Date reserCheckout;
	private Integer reserPeople;
	private Integer reserFood;
}
