package com.example.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.core.member.MemberRepository;
import com.example.core.member.MemoryMemberRepository;

public class ApplicationContextFindSameBeanTest {
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

	// NoUniqueBeanDefinitionException !
//	@Test
//	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 중복 오류 발생 ")
//	void findBeanByTypeDuplicate() {
//		assertThrows(NoUniqueBeanDefinitionException.class, () -> {
//			ac.getBean(MemberRepository.class);
//		});
//	}

	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상 있으면, 빈 이름을 지정하면 된다. ")
	void findBeanByName() {
		MemberRepository memberRepo = ac.getBean("memberRepo1", MemberRepository.class);
		assertThat(memberRepo).isInstanceOf(MemberRepository.class);
	}

	@Test
	@DisplayName("특정타입을 모두 조회하기 ")
	void findAllBeanByType() {
		Map<String, MemberRepository> map = ac.getBeansOfType(MemberRepository.class);
		for (String key : map.keySet()) {
			System.out.println("key = " + key + ", value = " + map.get(key));
		}
		System.out.println("beanOfType = " + map);
		assertThat(map.size()).isEqualTo(2);

	}

	@Configuration
	static class SameBeanConfig {
		@Bean
		public MemberRepository memberRepo1() {
			return new MemoryMemberRepository();
		}

		@Bean
		public MemberRepository memberRepo2() {
			return new MemoryMemberRepository();
		}
	}

}
