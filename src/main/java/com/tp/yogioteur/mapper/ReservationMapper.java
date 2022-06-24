package com.tp.yogioteur.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tp.yogioteur.domain.ReservationDTO;

@Mapper
public interface ReservationMapper {
	
	public int reservationInsert(ReservationDTO reservation);
	public List<ReservationDTO> reservationSelect(); 
	public ReservationDTO reservationSelectConfirm(String reserNo);
}
