package com.tp.yogioteur.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tp.yogioteur.domain.ReviewReplyDTO;

@Mapper
public interface ReviewReplyMapper {
	
		// 리뷰댓글 목록
		public List<ReviewReplyDTO> selectReviewReplyList(Long reviewNo);
		
		// 리뷰댓글 추가
		public int insertReviewReply(ReviewReplyDTO reviewReply);
		
		// 리뷰댓글 삭제
		public int deleteReviewReply(Long reviewNo);
	 
	

}
