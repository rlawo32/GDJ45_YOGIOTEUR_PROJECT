package com.tp.yogioteur.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import com.tp.yogioteur.domain.MemberDTO;
import com.tp.yogioteur.domain.SignOutMemberDTO;

public interface MemberService {
	
	public Map<String, Object> idCheck(String memberId);
	public Map<String, Object> sendAuthCode(String memberEmail);
	public Map<String, Object> emailCheck(String memberEmail);
	public void signIn(HttpServletRequest request, HttpServletResponse response);
	
	// 로그인
	public MemberDTO login(HttpServletRequest request);
	
	// 아이디 찾기
	public MemberDTO findId(HttpServletRequest request);
	
	// 비밀번호 찾기
	public Map<String, Object> idEmailCheck(MemberDTO member);
	public void changePw(HttpServletRequest request, HttpServletResponse response);
	
	// 회원정보 수정
	public void changeMember(HttpServletRequest request, HttpServletResponse response);
	
	// 탈퇴
//	public SignOutMemberDTO findSignOutMember(String memberId);
}
