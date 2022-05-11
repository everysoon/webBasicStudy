package com.example.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.AppConfig;
import com.example.core.member.MemberService;

public class SingletonTest {

	@Test
	@DisplayName("스프링없는 순수한 DI 컨테이너 ")
	void pureContainer() {
		AppConfig appConfig = new AppConfig();
		// 호출할때마다 객체를 생성 !
		MemberService memberService1 = appConfig.memberService();
		MemberService memberService2 = appConfig.memberService();
		// 참조값이 모두 다름!
		System.out.println("memberService 1 " + memberService1);
		System.out.println("memberService 2 " + memberService2);
		Assertions.assertThat(memberService1).isNotSameAs(memberService2);
	}

	@Test
	@DisplayName("싱글톤 패턴을 적용한 객체 사용")
	void singletonServiceTest() {
		SingletonService s1 = SingletonService.getInstance();
		SingletonService s2 = SingletonService.getInstance();
		System.out.println("singleton Service 1 " + s1);
		System.out.println("singleton Service 2 " + s2);

		// isSameAs : == 비교
		// isEqualsTo : equal 비교
		assertThat(s1).isSameAs(s2);
	}

	@Test
	@DisplayName("스프링 컨테이너와 싱글톤 ")
	void springContainer() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		// 호출할때마다 객체를 생성 !
		MemberService memberService1 = ac.getBean("memberService", MemberService.class);
		MemberService memberService2 = ac.getBean("memberService", MemberService.class);
		// 참조값이 모두 다름!
		System.out.println("memberService 1 " + memberService1);
		System.out.println("memberService 2 " + memberService2);
		Assertions.assertThat(memberService1).isSameAs(memberService2);
	}

}
