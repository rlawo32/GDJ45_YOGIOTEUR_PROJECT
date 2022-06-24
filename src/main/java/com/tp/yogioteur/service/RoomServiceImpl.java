package com.tp.yogioteur.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tp.yogioteur.mapper.RoomMapper;


@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	private RoomMapper roomMapper;
	
	@Override
	public void saveRoom(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {
		// 첨부된 모든 파일들
		List<MultipartFile> files = multipartRequest.getFiles("files");  // 파라미터 files
				
		// 파일 첨부 결과
		int fileAttachResult;
		if(files.get(0).getOriginalFilename().isEmpty()) {  // 첨부가 없으면 files.size() == 1임. [MultipartFile[field="files", filename=, contentType=application/octet-stream, size=0]] 값을 가짐.
			fileAttachResult = 1;
		} else {  // 첨부가 있으면 "files.size() == 첨부파일갯수"이므로 fileAttachResult = 0으로 시작함.
			fileAttachResult = 0;
		}
				
				
	}

	@Override
	public void roomList(HttpServletRequest request, Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> findRooms() {
		// TODO Auto-generated method stub
		return null;
	}
}
