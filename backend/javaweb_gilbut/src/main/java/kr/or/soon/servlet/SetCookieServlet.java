package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/setCookie")
public class SetCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		// 값 넣을땐 encoder이용 !
		Cookie cookie = new Cookie ("testCookie",URLEncoder.encode("JSP프로그래밍\n 현재시간 : "+new Date(),"utf-8"));
		cookie.setMaxAge(24*60*60);// 유효기간설정 ->persistence쿠키로설정
		response.addCookie(cookie);
		pw.print("현재시간 "+ new Date());
		pw.print("문자열을 cookie에 저장합니다");
	}

}
