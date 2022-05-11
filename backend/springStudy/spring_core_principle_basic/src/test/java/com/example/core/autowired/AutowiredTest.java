package com.example.core.autowired;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import com.example.core.member.Member;

public class AutowiredTest {

	/*
	 * 자동주입 옵션 :
	 * 
	 * @Autowired(required = false) : 자동 주입 대상이 없으면 setter가 호출 안 됨
	 * org.springframework.lan.@Nullable : 자동주입 대상 없으면 null 입력 Optional<> : 자동주입
	 * 대상없으면 Optional.empty 입력
	 */
	@Test
	void AutowiredOption() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
	}

	static class TestBean {

		@Autowired(required = false)
		public void setNoBean1(Member member) {
			// Member class는 스프링빈이 관리하는 클래스가 아님으로 setter자체가 호출안됨 : setNoBean1 메소드 아에 호출 x
			System.out.println("no Bean1 : " + member);
		}

		@Autowired
		public void setNoBean2(@Nullable Member member) {
			System.out.println("no Bean2 : " + member);
		}

		@Autowired
		public void setNoBean3(Optional<Member> member) {
			System.out.println("no Bean3 : " + member);
		}
	}

}
