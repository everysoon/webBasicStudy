package kr.or.soon.spring.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;


public class LoggingAdvice implements MethodInterceptor{

	//	MethodInterceptor를 이용한 어드바이스 클래스
	
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("메소드 호출 전 : LoggingAdvice ");
		System.out.println(invocation.getMethod() +" 메소드 호출 전");
		Object object = invocation.proceed(); // invocation을 활용해 메소드 호출
		System.out.println("메소드 호출 후 : LoggingAdvice ");
		System.out.println(invocation.getMethod() +" 메소드 호출 후");
		return object;
	}



}
