package com.tp.yogioteur.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tp.yogioteur.domain.MemberDTO;
import com.tp.yogioteur.service.MemberService;

@Controller
public class MemberController {
	
	// 회원가입
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/member/agreePage")
	public String agreePage() {
		return "member/agree";
	}
	
	@GetMapping("/member/signInPage")
	public String signInPage(@RequestParam(required=false) String[] agreements, Model model) {
		model.addAttribute("agreements", agreements);
		return "member/signIn";
	}
	
	@ResponseBody
	@GetMapping(value="/member/idCheck", produces="application/json")
	public Map<String, Object> idCheck(@RequestParam String memberId) {
		return memberService.idCheck(memberId);
	}
	
	
	@ResponseBody
	@GetMapping(value="/member/sendAuthCode", produces="application/json")
	public Map<String, Object> sendAuthCode(@RequestParam String memberEmail){
		return memberService.sendAuthCode(memberEmail);
	}
	
	@ResponseBody
	@GetMapping(value="/member/emailCheck", produces="application/json")
	public Map<String, Object> emailCheck(@RequestParam String memberEmail){
		return memberService.emailCheck(memberEmail);
	}

	@PostMapping("/member/signIn")
	public void signIn(HttpServletRequest request, HttpServletResponse response) {
		memberService.signIn(request, response);
	}
	

	
	// 로그인
	@GetMapping("/member/loginPage")
	public String loginPage(@RequestParam(required = false) String url, Model model) {
		model.addAttribute("url", url);
		return "member/login";
	}
	
	@PostMapping("/member/login")
	public void login(HttpServletRequest request, Model model) {
		
		MemberDTO loginMember = memberService.login(request);
		if(loginMember != null) {
			model.addAttribute("loginMember", loginMember);
			System.out.println(loginMember);
		}
		model.addAttribute("url", request.getParameter("url"));
	}
	
	// 로그아웃
	@GetMapping("/member/logout")
	public String logout(HttpSession session, HttpServletResponse response) { 

		MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");	
		if (loginMember != null) {
				session.invalidate(); 
			}
		return "redirect:/";
	}
	
	
	// 아이디찾기
	@GetMapping("/member/findIdPage")
	public String findIdPage() {
		return "member/findId";
	}
	
	@PostMapping("/member/findId")
	public String findId(HttpServletRequest request, Model model) {
		model.addAttribute("memberConfirm", memberService.findId(request));
		return "member/findIdResult";
	}
	

	
	// 비밀번호찾기
	@GetMapping("/member/findPwPage")
	public String findPwPage() {
		return "member/findPw";
	}
	
	@ResponseBody
	@GetMapping("/member/idEmailCheck")
	public Map<String, Object> idEmailCheck(MemberDTO member) {
		return memberService.idEmailCheck(member);
	}
	
	@ResponseBody
	@PostMapping(value = "/member/findPw")
	public void findPw(HttpServletRequest request, HttpServletResponse response){
		memberService.changePw(request, response);
	}
	
	// intercept 테스트 매핑
	@GetMapping("/board/reviewPage")
	public String reservationPage() {
		return "board/review";
	}
	
	
	// 회원 수정
	@GetMapping("/member/memberPage")
	public String memberPage(){
		return "member/memberInfo";
	}
	
	@PostMapping("/member/modifyMember")
	public void modifyMember(HttpServletRequest request, HttpServletResponse response){
		memberService.changeMember(request, response);
	}
	
	// 회원 탈퇴
//	@GetMapping("/member/signOut")
//	public void signOut(HttpServletRequest request, HttpServletResponse response) {
//		memberService.signOut(request, response);
//	}
}
