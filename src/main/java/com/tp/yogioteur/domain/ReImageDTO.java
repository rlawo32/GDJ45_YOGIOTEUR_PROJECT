package com.tp.yogioteur.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReImageDTO {
	
	private Long reImageNo;
	private Long reviewNo;
	private String reImagePath;
	private String reImageSaved;
	private String reImageOrigin;
}
