package kr.or.soon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet01 extends HttpServlet{
	// HttpServlet을 상속받고 생명주기 메소드를 차례로 구현
	// web.xml에 서블릿 매핑해서 서블릿요청 설정하기.
	// web.xml 서블릿 설정하는 방법 : Servlet01.java와 Servlet02.java로 실습
	// 서블릿 매핑 -> servlet태그 안에 servlet-name(지정), servlet-class(서블릿 자바클래스가 있는 곳)지정
	// servlet-mapping을 통해 servlet-name 안에 servlet태그안에 지정해준 이름, url-pattern에 매핑할 url주소 적어주고
	// 톰캣 서버 실행 뒤 url-pattern에 지정해준 url로 요청 
	@Override 
	public void init() throws ServletException{
		System.out.println("init 메소드 호출 >>>> servlet 01");
	}
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		System.out.println("doGet 메소드 호출 >>>> servlet 01");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출 >>>> servlet 01");
	}
}
