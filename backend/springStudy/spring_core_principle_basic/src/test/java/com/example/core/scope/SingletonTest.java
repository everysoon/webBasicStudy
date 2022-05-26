package com.example.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletonTest {

	@Test
	void singletonBeanFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletoneBean.class);
		SingletoneBean singletoneBean1 = ac.getBean(SingletoneBean.class);
		SingletoneBean singletoneBean2 = ac.getBean(SingletoneBean.class);
		System.out.println("singletoneBean1 : " + singletoneBean1);
		System.out.println("singletoneBean2 : " + singletoneBean2);
		assertThat(singletoneBean1).isSameAs(singletoneBean2);

		ac.close();
	}

	@Scope("singleton")
	static class SingletoneBean {
		@PostConstruct
		public void init() {
			System.out.println("singletonBean init");
		}

		@PreDestroy
		public void colse() {
			System.out.println("singletoneBean close");
		}

	}
}
