package com.example.core.order;

import org.junit.jupiter.api.Test;

import com.example.core.discount.RateDiscountPolicy;
import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {

	@Test
	void createOrder() {
		MemoryMemberRepository memberRepository = new MemoryMemberRepository();
		memberRepository.save(new Member(1L, "name", Grade.VIP));

		OrderServiceImpl orderServiceImpl = new OrderServiceImpl(memberRepository, new RateDiscountPolicy());

		orderServiceImpl.createOrder(1L, "item1", 1000);
	}
}
