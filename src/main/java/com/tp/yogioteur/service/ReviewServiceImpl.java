package com.tp.yogioteur.service;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.tp.yogioteur.domain.ReImageDTO;
import com.tp.yogioteur.domain.ReviewDTO;
import com.tp.yogioteur.mapper.ReviewMapper;
import com.tp.yogioteur.util.MyFileUtils;
import com.tp.yogioteur.util.PageUtils;


@Service 
public class ReviewServiceImpl implements ReviewService {

	  @Autowired
	  private ReviewMapper reviewMapper;
	  
	 
	  // 목록보기
	  @Override
	  public void ReviewList(HttpServletRequest request, Model model) {
		  Optional<String> opt = Optional.ofNullable(request.getParameter("page"));
		  int page = Integer.parseInt(opt.orElse("1"));
		
		  int totalRecord = reviewMapper.selectReviewCount();
		  
		  PageUtils pageUtils = new PageUtils();
		  pageUtils.setPageEntity(totalRecord, page);
		  
		  Map<String, Object> map  = new HashMap<String, Object>();
		  map.put("beginRecord", pageUtils.getBeginRecord());
		  map.put("endRecord", pageUtils.getEndRecord());
		  
		  List<ReviewDTO> reviews = reviewMapper.selectReviewList(map);
		  
		  model.addAttribute("totalRecrod", totalRecord);
		  model.addAttribute("reviews", reviews);
		  model.addAttribute("beginNo", totalRecord - (page - 1) * pageUtils.getRecordPerPage() );
		  model.addAttribute("paging", pageUtils.getPaging(request.getContextPath() + "/review/reviewList"));
		  
		  
	  }
	  

	  
	  @Override
	  public ResponseEntity<byte[]> display(Long reviewNo, String type) {
		
		  // 보내줘야 할 이미지 정보(path, saved)읽기
		  ReImageDTO reImage = reviewMapper.selectReImage(reviewNo);
		  ResponseEntity<byte[]> entity = null;
		  
		  // 보내줘야 할 이미지
		  if(reImage != null ) {
			  
			  File file = new File(reImage.getReImagePath(), reImage.getReImageSaved());
			  
			  try {
				  
				  HttpHeaders headers = new HttpHeaders();
				  headers.add("Content-Type", Files.probeContentType(file.toPath()));
				  entity = new ResponseEntity<>(FileCopyUtils.copyToByteArray(file), headers, HttpStatus.OK);				  
				  
				  
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
		  }
		  
		  
		return entity;
	  }
	  
	  //리뷰 저장
	  @Override
	  public void ReviewSave(MultipartHttpServletRequest multipartRequest, HttpServletResponse response) {

		  String reviewTitle = multipartRequest.getParameter("reviewTitle");
		  String reviewContent = multipartRequest.getParameter("reviewContent");
		  int reviewRevNo = Integer.parseInt(multipartRequest.getParameter("reviewRevNo")) ;
		  
		  //REVIEW
		  ReviewDTO review = ReviewDTO.builder()
				  .reviewTitle(reviewTitle)
				  .reviewContent(reviewContent)
				  .reviewRevNo(reviewRevNo)
				  .build();
		  
		  //REVIEW INSERT 수행
		  int ReviewResult = reviewMapper.insertReview(review);
		  
		  List<MultipartFile> files = multipartRequest.getFiles("files");
		  
		// 파일 첨부 결과
			int ReImageResult;
			if(files.get(0).getOriginalFilename().isEmpty()) {  // 첨부가 없으면 files.size() == 1임. [MultipartFile[field="files", filename=, contentType=application/octet-stream, size=0]] 값을 가짐.
				ReImageResult = 1;
			} else {  // 첨부가 있으면 "files.size() == 첨부파일갯수"이므로 fileAttachResult = 0으로 시작함.
				ReImageResult = 0;
			}
		
			
			for (MultipartFile multipartFile : files) {
				
				// 예외 처리는 기본으로 필요함.
				try {
					
					// 첨부가 없을 수 있으므로 점검해야 함.
					if(multipartFile != null && multipartFile.isEmpty() == false) {  // 첨부가 있다.(둘 다 필요함)
						
						// 첨부파일의 본래 이름(origin)
						String origin = multipartFile.getOriginalFilename();
						origin = origin.substring(origin.lastIndexOf("\\") + 1);  // IE는 본래 이름에 전체 경로가 붙어서 파일명만 빼야 함.
						
						// 첨부파일의 저장된 이름(saved)
						String saved = MyFileUtils.getUuidName(origin);
						
						// 첨부파일의 저장 경로(디렉터리)
						String path = MyFileUtils.getTodayPath();
						
						// 저장 경로(디렉터리) 없으면 만들기
						File dir = new File(path);
						if(dir.exists() == false) {
							dir.mkdirs();
						}
						
						// 첨부파일
						File file = new File(dir, saved);
						
						// 첨부파일 확인
						String contentType = Files.probeContentType(file.toPath());  // 이미지의 Content-Type(image/jpeg, image/png, image/gif)
						if(contentType.startsWith("image")) {
							
							// 첨부파일 서버에 저장(업로드)
							multipartFile.transferTo(file);
						
							
							// ReImageDTO
							ReImageDTO reImage = ReImageDTO.builder()
									.reImagePath(path)
									.reImageOrigin(origin)
									.reImageSaved(saved)
									.reviewNo(review.getReviewNo())
									.build();
							
							// FileAttach INSERT 수행
							ReImageResult += reviewMapper.insertReImage(reImage);
							
						}

					}
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
			// 응답
			try {
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				if(ReviewResult == 1 && ReImageResult == files.size()) {
					out.println("<script>");
					out.println("alert('리뷰가 등록되었습니다.')");
					out.println("location.href='" + multipartRequest.getContextPath() + "/review/reviewList'");
					out.println("</script>");
					out.close();
				} else {
					out.println("<script>");
					out.println("alert('리뷰가 등록되지 않았습니다.')");
					out.println("history.back()");
					out.println("</script>");
					out.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	  }
	  
	  // 리뷰 삭제
	  @Override
	  public void removeReview(HttpServletRequest request, HttpServletResponse response) {
		  
		  Optional<String> opt = Optional.ofNullable(request.getParameter("reviewNo"));
		  Long reviewNo = Long.parseLong(opt.orElse("0"));
		
		  
		  
		  ReImageDTO reImage = reviewMapper.selectReImage(reviewNo);
		  

		  if(reImage != null) {
			  
			  File file = new File(reImage.getReImagePath(), reImage.getReImageSaved());
			  
			  try {
				  
				  String contentType = Files.probeContentType(file.toPath());
				  if(contentType.startsWith("image")) {
					  
					  if(file.exists()) {
						  file.delete();
					  }
					  
				  }
				   
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
			  
			  
			  
			  int resImg = reviewMapper.deleteReImage(reviewNo);
				 
			  int resRev = reviewMapper.deleteReview(reviewNo);
			  
			  try {
				  
				  response.setContentType("text/html");
				  PrintWriter out = response.getWriter();
				  if(resImg==1 && resRev ==1 ) {
					  out.println("<script>");
					  out.println("alert('리뷰가 삭제되었습니다')");
					  out.println("location.href='" + request.getContextPath() + "/review/reviewList'");
					  out.println("</script>");
					  out.close();
				  } else {
					  out.println("<script>");
					  out.println("alert('리뷰가 삭제되지 않았습니다')");
					  out.println("history.back()");
					  out.println("</script>");
					  out.close();
				  }
				  
				  
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
			  
			  
			  
		  } else {
			  
			  int resRev = reviewMapper.deleteReview(reviewNo);
			  
			  try {
				  
				  response.setContentType("text/html");
				  PrintWriter out = response.getWriter();
				  if(resRev == 1 ) {
					  out.println("<script>");
					  out.println("alert('리뷰가 삭제되었습니다')");
					  out.println("location.href='" + request.getContextPath() + "/review/reviewList'");
					  out.println("</script>");
					  out.close();
				  } else {
					  out.println("<script>");
					  out.println("alert('리뷰가 삭제되지 않았습니다')");
					  out.println("history.back()");
					  out.println("</script>");
					  out.close();
				  }
				  
				  
			  }catch (Exception e) {
				  e.printStackTrace();
			  }
			  
		  }
		    
		  
	  }
	  

}