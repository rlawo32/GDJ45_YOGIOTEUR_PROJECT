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
public class ReviewReplyDTO {
	
	private Long replyNo;
	private Long reviewNo;
	private Long memberNo;
	private String replyContent;
	private Date replyCreated;
}
