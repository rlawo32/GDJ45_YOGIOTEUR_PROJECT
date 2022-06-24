package com.tp.yogioteur.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tp.yogioteur.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	private RoomService roomService;
	
	@GetMapping("/room/reservationPage")
	public String reservationPage() {
		return "room/roomList";
	}
	
	
	@PostMapping("/room/save")
	public void save(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		roomService.saveRoom(multipartRequest, response);
	}
	
}
