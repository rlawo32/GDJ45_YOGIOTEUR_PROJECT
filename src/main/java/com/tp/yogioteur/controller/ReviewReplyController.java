package com.tp.yogioteur.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.yogioteur.service.ReviewReplyService;


@Controller
public class ReviewReplyController {
	@Autowired
	private ReviewReplyService reviewReplyService;
	
	@ResponseBody
	@GetMapping(value="/reply/reviewReplyList", produces="application/json; charset=UTF-8")
	public Map<String, Object> reviewReplyList(@RequestParam Long reviewNo){
		return reviewReplyService.ReviewReplyList(reviewNo);
	}
	
	@ResponseBody
	@PostMapping(value="/reply/reviewReplySave", produces="application/json; charset=UTF-8")
	public Map<String, Object> reviewReplySave(HttpServletRequest request){
		return reviewReplyService.ReviewReplySave(request);
	}
	
	@ResponseBody
	@GetMapping(value="/reply/reviewReplyRemove", produces="application/json; charset=UTF-8")
	public Map<String, Object> reviewReplyRemove(@RequestParam Long replyNo){
		return reviewReplyService.ReviewReplyRemove(replyNo);
	}
}