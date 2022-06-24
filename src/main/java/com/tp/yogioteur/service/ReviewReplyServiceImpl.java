package com.tp.yogioteur.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.yogioteur.domain.ReviewReplyDTO;
import com.tp.yogioteur.mapper.ReviewReplyMapper;


@Service 
public class ReviewReplyServiceImpl implements ReviewReplyService {

	@Autowired
	private ReviewReplyMapper reviewReplyMapper;
	
	@Override
	public Map<String, Object> ReviewReplyList(Long reviewNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("reviewReply", reviewReplyMapper.selectReviewReplyList(reviewNo));
		return map;
	}

	@Override
	public Map<String, Object> ReviewReplySave(HttpServletRequest request) {
		ReviewReplyDTO reviewReply = ReviewReplyDTO.builder()
				.reviewNo(Long.parseLong(request.getParameter("reviewNo")))
				.replyContent(request.getParameter("replyContent"))
				.build();
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("res", reviewReplyMapper.insertReviewReply(reviewReply));
		
		return map;
	}

	@Override
	public Map<String, Object> ReviewReplyRemove(Long replyNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("res", reviewReplyMapper.deleteReviewReply(replyNo));
		return map;
	}

}