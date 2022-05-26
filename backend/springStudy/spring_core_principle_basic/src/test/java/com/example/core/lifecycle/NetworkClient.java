package com.example.core.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
	private String url;

	public NetworkClient() {
		System.out.println("url = " + url);

	}

	public void setUrl(String url) {
		this.url = url;
	}

	// 서비스 시작 시 호출
	public void connect() {
		System.out.println("connect" + url);
	}

	public void call(String msg) {
		System.out.println("call " + msg);
	}

	public void disconnect() {
		System.out.println("disconnect !" + url);
	}

	// 프로퍼티 세팅이끝나면 (의존관계 주입이 끝나면 호출되는 메소드)
	@PostConstruct
	public void init() throws Exception {
		connect();
		call("초기화 연결 메세지 ");

	}

	@PreDestroy
	public void close() throws Exception {
		disconnect();
	}

}
