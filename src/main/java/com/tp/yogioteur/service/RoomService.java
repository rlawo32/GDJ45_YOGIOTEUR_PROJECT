package com.tp.yogioteur.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface RoomService {
	
	//체크인체크아웃 전송
	public void roomList(HttpServletRequest request, Model model);
	
	
	
	//관리자 등록, 조회
	public void saveRoom(MultipartHttpServletRequest request, HttpServletResponse response);
	public Map<String, Object> findRooms();
	
}
