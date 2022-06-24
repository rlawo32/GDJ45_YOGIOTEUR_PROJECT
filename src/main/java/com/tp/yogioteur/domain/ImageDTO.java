package com.tp.yogioteur.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO {
	
	private Long imageNo;
	private Long roomNo;
	private String imagePath;
	private String imageSaved;
	private String imageOrigin;
	
}
