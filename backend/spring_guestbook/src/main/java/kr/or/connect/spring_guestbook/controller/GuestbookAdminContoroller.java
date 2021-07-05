package kr.or.connect.spring_guestbook.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.or.connect.spring_guestbook.service.LoginService;

//로그인 폼을 요청하면 처리, 로그인요청하면 로그인 처리
@Controller
public class GuestbookAdminContoroller {
	@Autowired
	LoginService service;
	
	@GetMapping(path="/loginform")
	public String loginform() {
		return "loginform";
	}
	@GetMapping(path="/registerform")
	public String registerform() {
		return "registerform";
	}
	@PostMapping(path="/login")
	public String login(@RequestParam(name="id",required = true) String id,
			@RequestParam(name="password",required =  true) String password,
			HttpSession session,
			RedirectAttributes redirectAttr) {
		boolean loginOk = service.login(id, password);
		if(loginOk) {
			session.setAttribute("isAdmin", loginOk);
		}else {
			redirectAttr.addFlashAttribute("errorMessage","로그인 에러!");
			return "registerform";
		}
		return "redirect:/list";
	}
	/*@PostMapping(path="/register")
	public String register(@RequestParam(name="id",required = true) String id,
			@RequestParam(name="password",required =  true) String password,
			HttpSession session,
			RedirectAttributes redirectAttr,
			ModelMap modelmap) {
		Map<String, String> map = service.register(id, password);
		boolean regiOk =Boolean.getBoolean(map.get("valid"));
		System.out.println("regiOk : "+ regiOk);
		if(regiOk) {
			session.setAttribute("id", id);
			session.setAttribute("password", password);
			return "redirect:/login";
		}else {
			modelmap.put("registerFail", false);
			return "registerform";
		}
		
	}*/
}
