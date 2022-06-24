package com.tp.yogioteur.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface ReviewReplyService {
	
		//리뷰댓글 목록
		public Map<String, Object> ReviewReplyList(Long reviewNo);
		
		// 리뷰 댓글 추가
		public Map<String, Object> ReviewReplySave(HttpServletRequest request);
		
		// 리뷰 댓글 삭제
		public Map<String, Object> ReviewReplyRemove(Long replyNo);
	
}
