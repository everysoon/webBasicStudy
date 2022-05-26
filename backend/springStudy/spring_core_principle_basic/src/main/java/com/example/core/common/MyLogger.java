package com.example.core.common;

import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

	private String uuid;
	private String requestURL;

	public void setRequestURL(String requestURL) {
		this.requestURL = requestURL;
	}

	public void log(String msg) {
		System.out.println("[" + uuid + "]" + " [" + requestURL + "]" + " [" + msg + "]");
	}

	@PostConstruct
	public void init() {
		uuid = UUID.randomUUID().toString();
		System.out.println("[" + uuid + "] request scope init" + this);
	}

	@PreDestroy
	public void close() {
		System.out.println("[" + uuid + "] request scope destory" + this);
	}
}
