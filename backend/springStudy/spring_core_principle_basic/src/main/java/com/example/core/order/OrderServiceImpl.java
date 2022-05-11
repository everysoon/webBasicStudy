package com.example.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.core.discount.DiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRepository;

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
	private final DiscountPolicy discountPolicy;

	@Autowired
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	}

	@Override
	public Order createOrder(Long id, String itemName, int itemPrice) {

		Member member = memberRepository.findById(id);

		int discountPrice = discountPolicy.discount(member, itemPrice);

		return new Order(id, itemName, itemPrice, discountPrice);

	}

	public MemberRepository getMemberRepo() {
		return memberRepository;
	}

}
