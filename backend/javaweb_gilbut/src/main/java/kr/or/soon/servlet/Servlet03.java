package kr.or.soon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/03")
public class Servlet03 extends HttpServlet{
	// HttpServlet을 상속받고 생명주기 메소드를 차례로 구현
	// 서블릿03 부터는 web.xml에 서블릿 매핑해주지않고
	// @WebServlet('url')어노테이션을 통한 서블릿 매핑 실행
	// @WebServlet 어노테이션을 사용하기위해선, HttpServlet을 상속받아야 한다.
	// 매핑이름은 다른 이름과 중복되지 않도록 주의!
	@Override 
	public void init() throws ServletException{
		System.out.println("init 메소드 호출>>>> servlet 03");
	}
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
	throws ServletException,IOException{
		System.out.println("doGet 메소드 호출>>>> servlet 03");
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출>>>> servlet 03");
	}
}
