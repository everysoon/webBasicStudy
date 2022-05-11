package com.example.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.core.discount.DiscountPolicy;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 중복오류가 발생한다.")
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> {
			DiscountPolicy bean = ac.getBean(DiscountPolicy.class);
		});
	}

	@Test
	@DisplayName("부모 타입으로 조회시, 자식이 둘 이상 있으면, 빈이름을 지정하면 된다.")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy bean = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("특정 하위 타입으로 조회")
	void findBeanBySubType() {
		DiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
		assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("부모 타입으로 모두 조회")
	void findAllBeanByParentType() {
		Map<String, DiscountPolicy> beans = ac.getBeansOfType(DiscountPolicy.class);
		assertThat(beans.size()).isEqualTo(2);
		for (String key : beans.keySet()) {
			System.out.println("key = " + key + ", value =" + beans.get(key));
		}
	}

	@Test
	@DisplayName("부모 타입으로 모두 조회 - Object")
	void findAllBeanByObjectType() {
		Map<String, Object> beans = ac.getBeansOfType(Object.class);

		for (String key : beans.keySet()) {
			System.out.println("key = " + key + ", value =" + beans.get(key));
		}
	}

	@Configuration
	static class TestConfig {

		@Bean
		public DiscountPolicy rateDiscountPolicy() {
			return new RateDiscountPolicy();
		}

		@Bean
		public DiscountPolicy fixDiscountPolicy() {
			return new FixDiscountPolicy();
		}
	}
}
