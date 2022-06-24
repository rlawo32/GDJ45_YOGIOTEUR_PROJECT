package com.tp.yogioteur.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface FaqService {
	
	public void findFaqs(HttpServletRequest request, Model model);
	public int save(HttpServletRequest request);
	public int remove(Long faqNo);
	public void selectfaqSearch(HttpServletRequest request, Model model);
	
}
