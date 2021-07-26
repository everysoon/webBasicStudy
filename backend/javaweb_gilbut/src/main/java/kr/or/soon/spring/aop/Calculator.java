package kr.or.soon.spring.aop;

public class Calculator {
	public void add(int x, int y) {
		int result = x + y;
		print(result);
	}

	public void sub(int x, int y) {
		int result = x - y;
		print(result);
	}

	public void multi(int x, int y) {
		int result = x * y;
		print(result);
	}

	public void div(int x, int y) {
		int result = x / y;
		print(result);
	}

	public void print(int result) {
		System.out.println("결과는 : " + result);
	}
}
