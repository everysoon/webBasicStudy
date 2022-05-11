package com.example.core.beanDefinition;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.core.AppConfig;

public class BeanDefinitionTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

	@Test
	@DisplayName("빈 설정 메타정보 확인 !")
	void findApplicationBean() {
		String[] names = ac.getBeanDefinitionNames();
		for (String name : names) {
			BeanDefinition bd = ac.getBeanDefinition(name);
			if (bd.getRole() == BeanDefinition.ROLE_APPLICATION) {
				System.out.println("beanDefinition name :" + name + ", beanDefinition = " + bd);
			}
		}
	}

}
