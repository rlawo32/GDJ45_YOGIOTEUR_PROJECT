package com.tp.yogioteur.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tp.yogioteur.domain.ReImageDTO;
import com.tp.yogioteur.domain.ReviewDTO;

@Mapper
public interface ReviewMapper {
	
	
	  	//리뷰갯수 
		public int selectReviewCount();
	  
		//리뷰 목록가져오기 
		public List<ReviewDTO> selectReviewList(Map<String, Object>map); 
	  
		// 리뷰 사진가져오기
		public ReImageDTO selectReImage(Long reviewNo);
	  
		public ReImageDTO selectReviewByNo(Long reImage);
		
		
		
		// 리뷰 추가
		public int insertReview(ReviewDTO review); 
		
		// 리뷰 사진 추가 
		public int insertReImage(ReImageDTO reImage);
	  
	  
		// 리뷰 삭제 
		public int deleteReview(Long reviewNo);
	 
		// 리뷰 첨부사진 삭제
		public int deleteReImage(Long reviewNo);

}
