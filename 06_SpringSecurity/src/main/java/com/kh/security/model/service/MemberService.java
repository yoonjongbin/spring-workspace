package com.kh.security.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kh.security.model.dao.MemberDAO;
import com.kh.security.model.vo.Member;

@Service
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberDAO dao;
	
	public int registerMember(Member vo) {
		return dao.registerMember(vo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("멤버 서비스." + username);
		
		Member member = dao.getMemberById(username);
		if(member == null) {
			throw new UsernameNotFoundException("username : " + username + "not found");
		}
		System.out.println("ROLE과 비교할 AUTH : " + member.getAuthorities());
		return member;
		
	}
}
