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
public class FaqDTO {
	
	private Long rn;
	private Long faqNo;
	private String faqTitle;
	private String faqContent;
	private Date faqCreated;
}
