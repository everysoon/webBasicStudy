package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/session")
public class Servlet10_Session extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		// getSession을 통해 세션 없으면 새로만들고 있으면 반환
		// 세션 유효시간 설정하지않으면 30분!
		HttpSession session = request.getSession(); 
		pw.print("최초 세션 id : " + session.getId()+"<br>");
		pw.print("세션 생성 시간 : "+new Date(session.getLastAccessedTime())+"<br>");
		pw.print("최근 세션 접근 시간 : " +new Date(session.getLastAccessedTime())+"<br>");
		pw.print("세션 유효시간 : "+session.getMaxInactiveInterval()+"<br>");
		if(session.isNew()) {
			pw.print("새 세션이 만들어졌슴다");
		}
		session.invalidate();// 세션 강제 삭제
	}

}
