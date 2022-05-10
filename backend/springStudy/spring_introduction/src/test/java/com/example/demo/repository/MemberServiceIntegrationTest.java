package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

@SpringBootTest // 스프링 컨테이너와 테스트를 함께 실행
@Transactional // 테스트 케이스에 이 어노테이션이있으면 테스트 시작 전에 트랜잭션 시작하고 테스트 완료 후 항상 롤백하기 때문에 DB에 데이터 남지않음

public class MemberServiceIntegrationTest {

	@Autowired
	MemberService service;
	@Autowired
	MemberRepository repo;

//	@BeforeEach
//	public void beforeEach() {
//		repo = new MemoryMemberRepo();
//		service = new MemberService(repo);
//	}

//	@AfterEach
//	public void afterEach() {
//		repo.clearStore();
//	}

	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("soon123");

		// when
		Long id = service.join(member);
		// then
		Member m = service.findOne(id).get();
		Assertions.assertThat(member.getName()).isEqualTo(m.getName());

	}

	@Test
	public void 중복_회원_예외() {
		// given
		Member member1 = new Member();
		member1.setName("soon");

		Member member2 = new Member();
		member2.setName("soon");

		// when
		service.join(member1);

//		try {
//		service.join(member2);
//		fail("예외가 발생해야 함니");
//	} catch (IllegalStateException e) {
//		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//	}
		IllegalStateException e = assertThrows(IllegalStateException.class, () -> service.join(member2));
		assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
		// then
	}

	@Test
	void findMembers() {

	}

	@Test
	void findone() {

	}
}
