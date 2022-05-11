package com.example.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.core.AppConfig;

public class MemberServiceTest {
	MemberService service;

	@BeforeEach
	public void beforeEach() {
		AppConfig appConfig = new AppConfig();
		service = appConfig.memberService();
	}

	@Test
	void join() {
		// given
		Member member = new Member(1L, "memberT", Grade.VIP);
		// when
		service.join(member);
		Member findMember = service.findMember(1L);

		// then
		Assertions.assertThat(member).isEqualTo(findMember);
	}

	@Test
	void findMember() {
		// given

		// when
		// then
	}
}
