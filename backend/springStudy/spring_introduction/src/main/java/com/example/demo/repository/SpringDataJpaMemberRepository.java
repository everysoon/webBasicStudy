package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.Member;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

	// JPQL select m from Member m where m.name = ?
	// And Or 같은 이름이있음

	@Override
	Optional<Member> findByName(String name);

}
