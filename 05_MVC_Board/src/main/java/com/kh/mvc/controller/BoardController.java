package com.kh.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;
import com.kh.mvc.model.vo.Criteria;
import com.kh.mvc.model.vo.Paging;

@Controller
@RequestMapping("/board/*") // 공통된 주소는 뺄수 있다.
public class BoardController {

	String path = "D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";
	
	@Autowired
	private BoardService service;

//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public void list(Criteria cri, Model model) {
		List<Board> list = service.selectAll(cri);
		System.out.println(list);
		model.addAttribute("list", list);
		model.addAttribute("paging", new Paging(cri, service.getTotal()));
	}

	@GetMapping("/insert")
	public void insert() {

	}

	@PostMapping("/insert")
	public String insert(Board board) throws IllegalStateException, IOException {
		
		fileUpload(board);
		
		service.insertBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("/view")
	public void view(int no, Model model) {

		model.addAttribute("vo", service.select(no));
	}

	@GetMapping("/update")
	public void update(int no, Model model) {
		model.addAttribute("vo", service.select(no));
	}

	@PostMapping("/update")
	public String update(Board board) throws IllegalStateException, IOException {
		
	
		// 파일 업로드 기능 추가
		
//		MultipartFile file = board.getUploadFile();
//		System.out.println("file : " + file);
//
//		if (!file.isEmpty()) { // 업로드한 파일이 있는 경우!
//			System.out.println("파일의 사이즈 : " + file.getSize());
//			System.out.println("업로드된 파일명 : " + file.getOriginalFilename());
//			System.out.println("파일의 파라미터명 : " + file.getName());
//
//			String path = "D:\\spring-workspace\\05_MVC_Board\\src\\main\\webapp\\upload\\";
//
//			File copyFile = new File(path + file.getOriginalFilename());
//
//			file.transferTo(copyFile); // 업로드한 파일이 지정한 path 위치에 저장
//
//			// 데이터베이스에 경로 저장
//
//			board.setFile_Url("/upload/" + file.getOriginalFilename());
//
//		}
		fileUpload(board);
		service.updateBoard(board);
		return "redirect:/board/list";
	}

	@GetMapping("/delete")
	public String delete(int no) {
		Board board = service.select(no);
		
		if(board.getFile_Url()!=null) {
			File delFile = new File(path + board.getFile_Url().replace("/upload/", ""));
			delFile.delete();
		}
		
		service.deletBoard(no);
		return "redirect:/board/list";
	}
	
	@RequestMapping("/download")
	public ModelAndView downloadFile(String fileName) {
		HashMap map = new HashMap();
		map.put("path", path);
		return new ModelAndView("downloadView", map);
	}

	public void fileUpload(Board board) throws IOException {
		
		
		
		// 파일 업로드 기능 추가
		MultipartFile file = board.getUploadFile();

		if (!file.isEmpty()) {// 업로드한 파일이 있는 경우!
			
			// 기존에 파일이 있는 경우 삭제!
			if(board.getFile_Url()!=null) {
				File delFile = new File(path + board.getFile_Url().replace("/upload/", ""));
				delFile.delete();
			}
			
			
			
			// 파일 중복방지를 위한 UUID 적용(spring에서 제공해준다.)
			UUID uuid = UUID.randomUUID();
			String fileName = uuid.toString() + "_" + file.getOriginalFilename();
			
			File copyFile = new File(path + fileName);
			file.transferTo(copyFile);	// 업로드한 파일이 지정한 path 위치에 저장
			
			// 데이터 베이스에 경로 저장
			board.setFile_Url("/upload/" + fileName);
		}
	}

//	@PostMapping("/list")
//	
//	@PutMapping
//	
//	@DeleteMapping

}
