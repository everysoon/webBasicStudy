package com.example.core.scope;

import static org.assertj.core.api.Assertions.assertThat;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

public class SingletoneWithProtorypeTest1 {

	@Test
	void protoypeFind() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtorypeBean.class);
		ProtorypeBean protorypeBean1 = ac.getBean(ProtorypeBean.class);
		protorypeBean1.addCount();
		assertThat(protorypeBean1.getCount()).isEqualTo(1);

		ProtorypeBean protorypeBean2 = ac.getBean(ProtorypeBean.class);
		protorypeBean2.addCount();
		assertThat(protorypeBean2.getCount()).isEqualTo(1);

	}

	@Test
	void singletonClientUsePrototype() {
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class,
				ProtorypeBean.class);
		ClientBean clientBean1 = ac.getBean(ClientBean.class);
		int count1 = clientBean1.logic();
		assertThat(count1).isEqualTo(1);
		ClientBean clientBean2 = ac.getBean(ClientBean.class);
		int count2 = clientBean2.logic();
		assertThat(count2).isEqualTo(1);

	}

	@Scope("singleton")
	static class ClientBean {
//		private final ProtorypeBean protorypeBean; // 생성시점에 주입
//
//		@Autowired
//		public ClientBean(ProtorypeBean protorypeBean) {
//			this.protorypeBean = protorypeBean;
//		}
//
//		public int logic() {
//			protorypeBean.addCount();
//			return protorypeBean.getCount();
//		}
		@Autowired
		private Provider<ProtorypeBean> provider;

		public int logic() {
			ProtorypeBean protorypeBean = provider.get();
			protorypeBean.addCount();
			return protorypeBean.getCount();
		}

	}

	@Scope("prototype")
	static class ProtorypeBean {
		private int count = 0;

		public void addCount() {
			count++;
		}

		public int getCount() {
			return count;
		}

		@PostConstruct
		public void init() {
			System.out.println("prototype init" + this);
		}

		@PreDestroy
		public void destory() {
			System.out.println("destory!" + this);
		}
	}

}
