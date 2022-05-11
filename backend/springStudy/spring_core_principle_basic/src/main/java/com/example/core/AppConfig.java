package com.example.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;
import com.example.core.member.MemoryMemberRepository;
import com.example.core.order.OrderService;

@Configuration
public class AppConfig {

	// 애플리케이션의 실제동작에 필요한 구현체를 여기서 생성!
	// 다른 클래스 안에서는 추상화만 !
	// (생성자를 통해 주입해줌)

	@Bean
	public MemberService memberService() {
		System.out.println("memberService call");

		return new MemberServiceImpl(memberRepository());
	}

	@Bean
	public MemberRepository memberRepository() {
		System.out.println("memberRepository call");
		return new MemoryMemberRepository();
	}

	@Bean
	public DiscountPolicy discountPolicy() {
//		return new FixDiscountPolicy();
		return new RateDiscountPolicy();
	}

	@Bean
	public OrderService orderService() {
		System.out.println("orderService call");
		return null;
//		return new OrderServiceImpl(memberRepository(), discountPolicy());

	}
}
