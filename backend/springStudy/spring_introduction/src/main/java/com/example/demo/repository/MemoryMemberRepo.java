package com.example.demo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.example.demo.domain.Member;

//@Repository
public class MemoryMemberRepo implements MemberRepository {
	// 레포지토리 구현체
	private static Map<Long, Member> store = new HashMap<>();
	private static long sequence = 0L; // 키 값 : 실무에선 어텀롱?

	public void clearStore() {
		store.clear();
	}

	@Override
	public Member save(Member member) {
		member.setId(++sequence);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// null 일수도있으니 optional.ofNullable 로 감싸준다.
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String name) {
		// 람다식 옵셔널로 반환해
		return store.values().stream().filter(member -> member.getName().equals(name)).findAny();

	}

	@Override
	public List<Member> findAll() {
		return new ArrayList<>(store.values());
	}

}
