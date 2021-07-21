package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/show")
public class ShowMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String id="",password ="";
		Boolean isLogin = false;
		HttpSession session = request.getSession(false); // 없으면 null반환
		if(session!=null) {
			isLogin = (Boolean) session.getAttribute("isLogin");
			if(isLogin) {
				// 로긴 햇엇으면 정보 가져와
				id = (String ) session.getAttribute("login.id");
				password = (String ) session.getAttribute("login.password");
				pw.print("<html><body>아이디 : "+id+" <br> 패스워드 : "+password +"</body></html>");
			}else {
				response.sendRedirect("loginSessionWithDB.jsp");
			}
		}else {
			response.sendRedirect("loginSessionWithDB.jsp");
		}
	}

}
