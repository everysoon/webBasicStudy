package com.example.core.order;

import org.springframework.stereotype.Component;

import com.example.core.discount.DiscountPolicy;
import com.example.core.member.Member;
import com.example.core.member.MemberRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor // : final이 붙은 변수들을 가지고 생성자 만들어 줌
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
//	private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
//	@Autowired
//	public void setMemberRepository(MemberRepository memberRepository) {
//		this.memberRepository = memberRepository;
//	}
//
//	@Autowired
//	public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//		this.discountPolicy = discountPolicy;
//	}
//	@Autowired
//	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//		this.memberRepository = memberRepository;
//		this.discountPolicy = discountPolicy;
//	}

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
