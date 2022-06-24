package com.tp.yogioteur.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class AdminController {
	
	@GetMapping("/admin/adminPage")
	public String adminPage() {
		return "admin/adminPage";
	}
	
	@GetMapping("/admin/room")
	public String room() {
		return "admin/room";
	}
	
	@GetMapping("/admin/addRoomPage")
	public String addRoomPage() {
		return "admin/addRoom";
	}

}