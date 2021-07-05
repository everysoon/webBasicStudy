package kr.or.connect.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.connect.springmvc.dto.User;

@Controller
public class UserController {
	@RequestMapping(path="/userform",method=RequestMethod.GET)
	public String userForm() {
		return "userform";
	}
	// ModelAttribute로 선언해주면 객체를 하나 생성하고 
	// 값들 name과 일치하는 것끼리 데이터 넣어줌.
	@RequestMapping(path="/regist",method=RequestMethod.POST)
	public String regist(@ModelAttribute User user) {
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("user",user);
		System.out.println("사용자가 입력한 user정보입니다. \n 해당 정보를 이용하는 코드가 와야합니다.");
		System.out.println(user);
		return "regist";
	}
}
