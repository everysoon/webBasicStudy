package com.example.talkdrive;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
@RequiredArgsConstructor
public class TalkdriveApplication {

	public static void main(String[] args) {
		SpringApplication.run(TalkdriveApplication.class, args);
	}

}
