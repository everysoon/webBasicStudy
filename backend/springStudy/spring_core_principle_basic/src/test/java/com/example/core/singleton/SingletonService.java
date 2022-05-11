package com.example.core.singleton;

public class SingletonService {

	private static final SingletonService instance = new SingletonService();

	public static SingletonService getInstance() {
		return instance;
	}

	private SingletonService() {
		// private 생성자를 통해 밖에서 여러개 생성 못 하게!
	}

	public void logic() {
		System.out.println("call singleton logic");
	}
}
