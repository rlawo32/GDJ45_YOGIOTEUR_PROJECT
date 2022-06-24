package com.tp.yogioteur.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tp.yogioteur.service.ReviewService;


@Controller
public class ReviewController {

	@Autowired
	public ReviewService reviewService;
	
	@GetMapping("/review/reviewList")
	public String reviewList(HttpServletRequest request, Model model) {
		reviewService.ReviewList(request, model);
		return "review/reviewList";
	}
	
	@GetMapping("/review/reviewSavePage")
	public String reviewSavePage() {
		return"review/reviewSave";
	}
	
	@PostMapping("/review/reviewSave") public void
	reviewSave(MultipartHttpServletRequest multiparRequest, HttpServletResponse response) {
	
		reviewService.ReviewSave(multiparRequest, response); 
	
	}
	@ResponseBody
	@GetMapping("/review/display")
	public ResponseEntity<byte[]> display(Long reviewNo, @RequestParam(value="type", required=false, defaultValue="image") String type){
		return reviewService.display(reviewNo, type);
	}
	
	
	@GetMapping("/review/reviewRemove") 
	public void removeReview(HttpServletRequest request, HttpServletResponse response) {
		reviewService.removeReview(request, response);
	}
	 
	 
}