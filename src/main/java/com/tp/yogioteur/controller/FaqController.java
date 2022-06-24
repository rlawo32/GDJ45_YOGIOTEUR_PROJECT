package com.tp.yogioteur.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tp.yogioteur.service.FaqService;


@Controller
public class FaqController {

	@Autowired
	private FaqService faqService;
	
	@GetMapping("/faq/faqList")
	public String faqList(HttpServletRequest request, Model model) {
		faqService.findFaqs(request, model);
		return "faq/faqSearch";
	}
	
	@GetMapping("/faq/faqSavePage")
	public String faqSavePage() {
		return "faq/faqSave";
	}
	
	@PostMapping("/faq/faqSave")
	public String faqSave(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("insRes", faqService.save(request));
		redirectAttributes.addFlashAttribute("type", "insert");
		return "redirect:/faq/faqResult";
	}
	
	@GetMapping("/faq/faqResult")
	public String faqResult() {
		return "faq/faqResult";
	}
	
	@GetMapping("/faq/remove")
	public String remove(@RequestParam(value="faqNo", required=false, defaultValue = "0L") Long faqNo, RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("delRes", faqService.remove(faqNo));
		redirectAttributes.addFlashAttribute("type", "delete");
		return "redirect:/faq/faqResult";
	}
	
	@GetMapping("/faq/faqSearch")
	public String faqSearch(HttpServletRequest request, Model medle) {
		faqService.selectfaqSearch(request, medle);
		return "faq/faqSearch";
	}
	
}