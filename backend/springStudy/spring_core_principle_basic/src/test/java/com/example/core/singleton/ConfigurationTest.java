package com.example.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.AppConfig;
import com.example.core.member.MemberRepository;
import com.example.core.member.MemberServiceImpl;
import com.example.core.order.OrderServiceImpl;

public class ConfigurationTest {

	@Test
	@DisplayName("Configuration의 MemberRepo가 싱글톤이 깨지는지 봐보자 ")
	void configurationTest() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

		MemberRepository repo = ac.getBean("memberRepository", MemberRepository.class);
		MemberRepository memberRepo = memberService.getMemberRepo();
		MemberRepository orderRepo = orderService.getMemberRepo();

//		System.out.println("repo : " + repo);
//		System.out.println("memberRepo : " + memberRepo);
//		System.out.println("orderRepo : " + orderRepo);
		Assertions.assertThat(memberRepo).isEqualTo(orderRepo);
	}

	@Test
	void configurationDeep() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		AppConfig appConfig = ac.getBean(AppConfig.class);

		System.out.println("AppConfig :" + appConfig.getClass());
	}
}
