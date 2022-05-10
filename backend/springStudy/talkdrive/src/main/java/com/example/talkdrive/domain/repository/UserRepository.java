package com.example.talkdrive.domain.repository;

import com.example.talkdrive.domain.entitiy.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
