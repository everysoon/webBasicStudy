package kr.or.soon.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/loginListener")
public class LoginListenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String password =request.getParameter("password");
		LoginImpl loginUser = new LoginImpl(id,password);
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser); // 세션에 바인딩할때 LoginImpl의 valueBound()호출
		}
		String html = "<html><head><script type='text/javascript'>setTimeout('history.go(0);',5000)</script></head>"
				+ "<body>"
				+ "아이디 : "+loginUser.id+"<br>"
				+ "총 접속자 수 : "+loginUser.total+"<br>"
				+ "</body></html>";
		pw.print(html);
	}

}
