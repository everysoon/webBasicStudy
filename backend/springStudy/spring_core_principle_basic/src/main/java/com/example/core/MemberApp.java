package com.example.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemberService;

public class MemberApp {
	public static void main(String[] args) {
//		AppConfig appConfig = new AppConfig();

//		MemberService memberService = appConfig.memberService();
		// AnnotationConfigApplicationContext :AppConfig
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class); // 스프링 컨테이너
		// name 은 AppConfig의 메서드 이름으로 넣어주기 :memberService
		MemberService memberService = context.getBean("memberService", MemberService.class);

		Member member = new Member(1L, "member1", Grade.VIP);
		memberService.join(member);
		Member findMember = memberService.findMember(1L);
		System.out.println("findMember = " + findMember.getName());
		System.out.println("member = " + member.getName());
	}
}
