package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;
import com.example.demo.service.MemberService;

public class MemberServiceTest {
	MemberService service;
	MemoryMemberRepo repo;

	@BeforeEach
	public void beforeEach() {
		repo = new MemoryMemberRepo();

		service = new MemberService(repo);

	}

	@AfterEach
	public void afterEach() {
		// 테스트 후 데이터 클리어 하기 위함 모든 메소드 실행 후 이거 실행됨
		repo.clearStore();
	}

	@Test
	void 회원가입() {
		// given
		Member member = new Member();
		member.setName("soon");

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
		assertThrows(IllegalStateException.class, () -> service.join(member2));

		// then
	}

	@Test
	void findMembers() {

	}

	@Test
	void findone() {

	}
}
