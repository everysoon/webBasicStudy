package com.example.core.singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

	@Test
	@DisplayName("싱글톤의 문제점 ")
	void statefulServiceSingleton() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
		StatefulService ss1 = ac.getBean(StatefulService.class);
		StatefulService ss2 = ac.getBean(StatefulService.class);

		// ThreadA : A사용자가 만원 주문
//		ss1.order("userA", 10000);
		// ThreadB : B사용자가 이만원 주문
//		ss2.order("userB", 20000);

		// ThreadA : A사용자가 주문 금액 조회
		int price1 = ss1.order("userA", 10000);
		int price2 = ss2.order("userB", 20000);

		System.out.println("price1 : " + price1);
		System.out.println("price2 : " + price2);
		assertThat(price1).isEqualTo(price2);
	}

	static class TestConfig {
		@Bean
		public StatefulService statefulService() {
			return new StatefulService();
		}
	}
}
