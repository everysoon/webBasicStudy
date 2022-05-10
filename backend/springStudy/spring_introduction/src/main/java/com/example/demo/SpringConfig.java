package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.repository.MemberRepository;
import com.example.demo.service.MemberService;

@Configuration
public class SpringConfig {
//	private DataSource dataSource;
//	
//	@Autowired
//	public SpringConfig(DataSource dataSource) {
//		this.dataSource = dataSource;
//	}

//	@PersistenceContext
//	EntityManager em;
//
//	@Autowired
//	public SpringConfig(EntityManager em) {
//		this.em = em;
//	}
	private final MemberRepository memberRepository; // SpringDataJpaMemberRepository에 있는 MemberRepository를 주입받음

	@Autowired
	public SpringConfig(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;

	}

	@Bean
	public MemberService service() {
		return new MemberService(memberRepository);
	}

//	@Bean
//	public TimeTraceAop timeTraceAop() {
//		return new TimeTraceAop();
//	}
//	@Bean
//	public MemberRepository repo() {
//		return new MemoryMemberRepo();
//		return new JdbcMemberRepository(dataSource);
//		return new JdbcTemplateMemberRepository(dataSource);
//		return new JPAMemberRepository(em);

//	}
}
