package com.tp.yogioteur.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.tp.yogioteur.domain.ImageDTO;
import com.tp.yogioteur.domain.RoomDTO;

@Mapper
public interface RoomMapper {
	
	public int insertRoom(RoomDTO room);
	public int insertImage(ImageDTO image);
	
	public List<RoomDTO> selectRoomList();
	
	
	//checkin 방조회	
	
}
