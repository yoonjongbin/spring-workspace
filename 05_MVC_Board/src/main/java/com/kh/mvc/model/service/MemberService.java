package com.kh.mvc.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.mvc.model.dao.MemberDAO;
import com.kh.mvc.model.vo.Member;

@Service
public class MemberService implements UserDetailsService{
	
	@Autowired
	private MemberDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		
		System.out.println("서비스에 도착한 id : " + username);
		Member member = dao.getMemberById(username);
		System.out.println("ROLE과 비교할 AUTH : " + member.getAuthorities());;
		if(member==null) {
			throw new UsernameNotFoundException("username not found");
		}
		return member;
	}
	
}
