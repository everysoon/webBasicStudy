package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@Controller
public class MemberController {
	private final MemberService service;

	@Autowired
	public MemberController(MemberService service) {
		this.service = service;
	}

	@GetMapping("/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}

	@PostMapping("/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		System.out.println("member name :" + form.getName());
		member.setName(form.getName());
		service.join(member);
		return "redirect:/";
	}

	@GetMapping("/members")
	public String list(Model model) {
		List<Member> members = service.findMembers();
		model.addAttribute("members", members); // members라는 키로 List<Member>인 members저장 (html에서 members라는 키로 꺼내 씀)
		return "members/memberList"; // html 경로
	}
}
