package com.example.core.web;

import org.springframework.stereotype.Service;

import com.example.core.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LogDemoService {
	private final MyLogger myLogger;

	public void logic(String id) {
//		MyLogger myLogger = myProvider.getObject();
		myLogger.log("id :" + id);
	}

}
