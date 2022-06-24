package com.tp.yogioteur.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tp.yogioteur.domain.FaqDTO;
import com.tp.yogioteur.mapper.FaqMapper;
import com.tp.yogioteur.mapper.RoomMapper;
import com.tp.yogioteur.util.PageUtils;


@Service
public class FaqServiceImpl implements FaqService {

	@Autowired
	private FaqMapper faqMapper;
	
	@Override
	public void findFaqs(HttpServletRequest request, Model model) {

		int totalRecord = faqMapper.selectFaqCount();
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(totalRecord, page);
		
		Map<String, Object> map = new HashMap<>();
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		List<FaqDTO> faqs = faqMapper.selectFaqList(map);
		model.addAttribute("faqs", faqs);
		model.addAttribute("totalRecord", totalRecord);
		model.addAttribute("paging", pageUtils.getPaging(request.getContextPath() + "/faq/faqList"));
	}

	@Override
	public int save(HttpServletRequest request) {
		String title = request.getParameter("faqTitle");
		String content = request.getParameter("faqContent");
		
		FaqDTO faq = FaqDTO.builder()
				.faqTitle(title)
				.faqContent(content)
				.build();
		
		return faqMapper.insertFaq(faq);
	}

	@Override
	public int remove(Long faqNo) {
		return faqMapper.deleteFaq(faqNo);
	}
	
	@Override
	public void selectfaqSearch(HttpServletRequest request, Model model) {
		
		Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		int page = Integer.parseInt(opt.orElse("1"));
		
		String faqQuery = request.getParameter("faqQuery");
		String begin = request.getParameter("begin");
		String end = request.getParameter("end");
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("faqQuery", faqQuery);
		map.put("begin", begin);
		map.put("end", end);
		
		int findRecord = faqMapper.selectFindCount(map);
		
		PageUtils pageUtils = new PageUtils();
		pageUtils.setPageEntity(findRecord, page);
		
		map.put("beginRecord", pageUtils.getBeginRecord());
		map.put("endRecord", pageUtils.getEndRecord());
		
		List<FaqDTO> faqs = faqMapper.selectfaqSearch(map);
		
		model.addAttribute("faqs", faqs);
		model.addAttribute("beginNo", findRecord - pageUtils.getRecordPerPage() * (page - 1));
		model.addAttribute("paging", pageUtils.getPaging(request.getContextPath() + "/faq/faqSearch?faqQuery=" + faqQuery));
		
	}
}
