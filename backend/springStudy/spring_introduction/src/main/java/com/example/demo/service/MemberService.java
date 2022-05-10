package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.demo.domain.Member;
import com.example.demo.repository.MemberRepository;

// 서비스는 레포를 통해 데이터 넣고빼고를 이용해 로직짜는 곳
//@Service
@Transactional
public class MemberService {
	private final MemberRepository repo;

//	@Autowired
	public MemberService(MemberRepository repo) {
		this.repo = repo;
	}

	// 회원가
	public Long join(Member member) {
		// 같은 이름이 있는 중복확인 로직

		repo.findByName(member.getName()).ifPresent(m -> {
			throw new IllegalStateException("이미 존재하는 회원입니다.");
		});
		repo.save(member);
		return member.getId();

		// null이 아니라 값이 있으면 동작 : ifPresent
		// if null 이면~ 이런 처리 없어도 get으로 바로 꺼내도 되
//		Optional<Member> result = repo.findByName(member.getName());
//		result.ifPresent(m -> {
//			throw new IllegalStateException("이미 존재하는 회원입니다.");
//		}); 
		// 위의 문법 아래 문법으로 줄여쓰기 :중복회원 판별은 따로 메소드 빼서 해 ㅇ-ㅇ 일단은 요러케

	}

	// 전체 회원 조회
	public List<Member> findMembers() {
		return repo.findAll();
	}

	public Optional<Member> findOne(Long memberId) {
		return repo.findById(memberId);
	}
}
