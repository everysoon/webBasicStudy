package com.example.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class PrototypeTest {

	@Test
	void prototypeBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
		PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
		PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
		System.out.println("prototypeBean1 : " + prototypeBean1);
		System.out.println("prototypeBean2 : " + prototypeBean2);
		assertThat(prototypeBean1).isNotSameAs(prototypeBean2);

		ac.close();
	}

	// 프로토 타입 빈은 preDestory 가 전혀 실행되지 않는다 .
	// 요청되면 새로운 빈을 생성하고, 쓰고 버림 !
	@Scope("prototype")
	static class PrototypeBean {
		@PostConstruct
		public void init() {
			System.out.println("prototypeBean init");
		}

		@PreDestroy
		public void colse() {
			System.out.println("prototypeBean close");
		}

	}
}
