package com.example.core.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.AppConfig;
import com.example.core.member.MemberService;
import com.example.core.member.MemberServiceImpl;

class ApplicationContextBeanFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 이름으로 조회!")
	void findBeanName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		System.out.println("memberService :" + memberService);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

	}

	@Test
	@DisplayName("빈 이름없이 빈타입으로 조회!")
	void findBeanByType() {
		MemberService memberService = ac.getBean(MemberService.class);
//		System.out.println("memberService :" + memberService);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

	}

	@Test
	@DisplayName("구체 타입으로 조회!")
	void findBeanByType2() {
		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
		System.out.println("memberService :" + memberService);
		Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

	}

	@Test
	@DisplayName("빈 이름으로 조회 X!")
	void findBeanByNameX() {
		// assertThrows : 예외가 터져야 테스트 성공
		org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class, () -> {
			MemberService xxx = ac.getBean("xxxxx", MemberService.class);
		});
	}
}
