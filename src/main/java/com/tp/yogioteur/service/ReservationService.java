package com.tp.yogioteur.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface ReservationService {
	public void payments(HttpServletRequest request, HttpServletResponse response);
	public void confirms(HttpServletRequest request, Model model);
}
