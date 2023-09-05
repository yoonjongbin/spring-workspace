package com.kh.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mvc.model.service.MemberService;
import com.kh.mvc.model.vo.Member;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
//	@Autowired
//	private MemberService service;
	
//	@Autowired
//	private BCryptPasswordEncoder bcpe;
	
	@GetMapping("/login")
	public void login() {}
	
//	@PostMapping("/login")
//	public String login(Member member) {
//		System.out.println("이쪽으로 왔다.");
//		service.loadUserByUsername(member.getId());
//		return "redirect:/list";
//	}
	
	@GetMapping("/logout")
	public void logout() {
		
	}
	
}
