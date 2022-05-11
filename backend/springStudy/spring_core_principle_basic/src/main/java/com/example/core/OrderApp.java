package com.example.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemberService;
import com.example.core.order.Order;
import com.example.core.order.OrderService;

public class OrderApp {
	public static void main(String[] args) {

//		AppConfig appConfig = new AppConfig();

//		MemberService memberService = appConfig.memberService();
//		OrderService orderService = appConfig.orderService();
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberService memberService = context.getBean("memberService", MemberService.class);
		OrderService orderService = context.getBean("orderService", OrderService.class);
		Long memberId = 1L;
		Member member = new Member(memberId, "memberA", Grade.VIP);
		memberService.join(member);

		Order order = orderService.createOrder(memberId, "itemA", 10000);
		System.out.println("order = " + order);
		System.out.println("order = " + order.calPrice());

	}
}
