package com.tp.yogioteur.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.tp.yogioteur.domain.FaqDTO;

@Mapper
public interface FaqMapper {
	
	public List<FaqDTO> selectFaqList(Map<String, Object> map); // 목록보기
	public int selectFaqCount(); // 총 갯수
	
	public FaqDTO selectFaqByNo(Long faqNo); 
	public int insertFaq(FaqDTO faq); // 추가
	public int deleteFaq(Long faqNo); // 삭제
	
	public int selectFindCount(Map<String, Object> map);
	public List<FaqDTO> selectfaqSearch(Map<String, Object> map);
	
}
