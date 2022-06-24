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
public class SockatDTO {
	
	private Long soNo;
	private String soId;
	private String soNamd;
	private String soContent;
	private Date soDate;
}
