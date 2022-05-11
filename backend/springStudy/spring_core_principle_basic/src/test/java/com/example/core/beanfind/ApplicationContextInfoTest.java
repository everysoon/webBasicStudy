package com.example.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.AppConfig;

public class ApplicationContextInfoTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("모든 빈 출력 ")
	void findAllBean() {
		String[] beanDefinitaionNames = ac.getBeanDefinitionNames();
		for (String name : beanDefinitaionNames) {
			Object bean = ac.getBean(name);
//			System.out.println("name = " + name + ", object =" + bean);
		}
	}

	/*
	 * 빈 찾는 방법 1. ac.getBean(빈이름,타입); 2. ac.getBean(타입) 조회대상 스프링빈이 없으면 예외 발생
	 * :NoSuchBeanDefinitionException :No bean named 'xxxx' avaliable
	 */
	@Test
	@DisplayName("애플리케이션 빈 출력 ")
	void findApplicationBean() {
		String[] beanDefinitaionNames = ac.getBeanDefinitionNames();
		for (String name : beanDefinitaionNames) {
			BeanDefinition bean = ac.getBeanDefinition(name);
			// Role : ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
			// Role : ROLE_INFRASTRUCTURE : 스프링이 내부에서 사용하는 빈
			if (bean.getRole() == BeanDefinition.ROLE_APPLICATION) {

				System.out.println("name = " + name + ", object =" + bean);
			}

		}
	}
}
