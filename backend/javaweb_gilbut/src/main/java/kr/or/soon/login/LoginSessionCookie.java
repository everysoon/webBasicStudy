package kr.or.soon.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/loginSession")
public class LoginSessionCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		if(session.isNew()) {
			//세션 최초 생성시 실행
			if(id!=null||!id.equals("")) {
				session.setAttribute("id", id);
				pw.print("<a href='loginsession'> 로긴상태확인</a>");
			}else {
				pw.print("<a href='login/loginSession.jsp'>다시 로그인</a>");
				session.invalidate(); // 세션 삭제
			}
		}else{
			// 최초 생성이 아닌 재 로그인일 때
			id = (String) session.getAttribute("id");
			if(id!=null&&id.length()!=0) {
				pw.print("<h1>"+id+"님 안녕하세요</h1>");
			}else {
				pw.print("<a href='login/loginSession.jsp'>다시 로그인</a>");
				session.invalidate(); // 세션 삭제
			}
		}
	}

}
