package com.example.demo.repository;

import static org.assertj.core.api.Assertions.assertThat; //static import하면 더 쉽게 사용 가

import java.util.List;

import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.demo.domain.Member;

class MemoryMemberRepoTest {

	MemoryMemberRepo repo = new MemoryMemberRepo();

	@AfterEach
	public void afterEach() {
		// 테스트 후 데이터 클리어 하기 위함 모든 메소드 실행 후 이거 실행됨
		repo.clearStore();
	}

	@Test
	public void save() {
		Member member = new Member();
		member.setName("spring");
		repo.save(member);
		Member result = repo.findById(member.getId()).get();
		System.out.println("result = " + (result == member));
//		Assertions.assertEquals(member, result); 는 import org.junit.jupiter.api.Assertions

		// org.assertj.core.api.Assertions
		assertThat(member).isEqualTo(result);
	}

	@Test
	public void findByName() {
		Member member1 = new Member();
		member1.setName("soon");
		repo.save(member1);

		Member member2 = new Member();
		member2.setName("spring");
		repo.save(member2);

		Member result = repo.findByName(member1.getName()).get();

		assertThat(result).isEqualTo(member1);

	}

	@Test
	public void findAll() {
		Member member1 = new Member();
		member1.setName("spring1");
		repo.save(member1);
		Member member2 = new Member();
		member2.setName("spring2");
		repo.save(member2);

		List<Member> result = repo.findAll();
		assertThat(result.size()).isEqualTo(2);

	}
}
