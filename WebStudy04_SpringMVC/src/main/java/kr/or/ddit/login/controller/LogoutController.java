package kr.or.ddit.login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LogoutController {
	@PostMapping("/login/logout.do")
	public String logout(HttpSession session) {
//		session.removeAttribute("authMember");
		session.invalidate(); // session속성 삭제, 현재 페이지 session 강제로 만료
		
		return "redirect:/";
		
	}
}
