package com.kh.mvc.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
//		List<String> roleList = new ArrayList<>();
//		System.out.println("여기왔다.");
//
//		authentication.getAuthorities().forEach(auth -> {
//			System.out.println("auth : " + auth + roleList.size());
//			roleList.add(auth.getAuthority());
//			if(auth.equals("ROLE_MEMBER")) {
//				try {
//					response.sendRedirect("/member");
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//			}
//		}); // 우리가 만든 권한 2개를 받아온다.
//
//		if (roleList.contains("ROLE_MEMBER")) {
//			response.sendRedirect("/board/insert");
//			return;
//		}

		response.sendRedirect("/board/list");

	}

}
