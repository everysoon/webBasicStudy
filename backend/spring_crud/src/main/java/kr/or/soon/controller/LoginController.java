package kr.or.soon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import kr.or.soon.dto.Member;

@Controller("loginController") // 컨트롤러 빈 자동 생성
public class LoginController {

//	@PostMapping("/loginForm.do")
//	public String loginForm(@RequestParam(name = "id", required = true) String id,
//			@RequestParam(name = "password", required = true) String password,
//			ModelMap modelMap) {
//		modelMap.addAttribute("id",id);
//		modelMap.addAttribute("password", password);
//		return "result";
//	}
	@PostMapping("/loginForm.do")
	public String loginForm(@ModelAttribute("member") Member member
		) {
		System.out.println("member"+member);
		return "result";
	}
}
