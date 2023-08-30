package com.kh.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kh.mvc.model.service.BoardService;
import com.kh.mvc.model.vo.Board;

@Controller
@RequestMapping("/board/*")	// 공통된 주소는 뺄수 있다.
public class BoardController {
	@Autowired
	private BoardService service;
	
//	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@GetMapping("/list")
	public void list(Model model) {
		
		List<Board> list = service.selectAll();
		model.addAttribute("list",list);
	}
	
//	@PostMapping("/list")
//	
//	@PutMapping
//	
//	@DeleteMapping
	
	
	@RequestMapping("/insert")
	public void insert() {
		
	}
}
