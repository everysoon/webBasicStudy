package kr.or.soon.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class LoginServletURL extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	// 웹 페이지 연동방법
	// 1. hidden 태그 : <input type="hidden"> 
	// ** 2. URL rewriting : GET방식으로 URL뒤에 정보를 붙여 다른페이지로 전송
	// 3. 쿠키 : 클라이언트 PC의 쿠키파일에 정보를 저장한 후 웹페이지들이 공유
	// 4. 세션 : 서버 메모리에 정보를 저장한 후 웹페이지들이 공유
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		String tel = request.getParameter("tel");
		System.out.println("id"+id);
		System.out.println("password"+password);
		System.out.println("addr"+addr);
		System.out.println("email"+email);
		System.out.println("tel"+tel);
		String html ;
		if(id!=null&&password!=null&&!id.equals("")&&!password.equals("")) {
		 html = "<html><body><h1>여기는 login2 서블릿!"+id+"님 로그인하셧슴다</h1><table>"
				+ "<tr><td>id</td><td>"+id+"</td></tr>"
				+ "<tr><td>password</td><td>"+password+"</td></tr>"
				+ "<tr><td>email</td><td>"+email+"</td></tr>"
				+ "<tr><td>addr</td><td>"+addr+"</td></tr>"
				+ "<tr><td>tel</td><td>"+tel+"</td></tr>"
				+ "</table></body></html>";
		}else {
			 html = "<html><body><h1>로그인 하지 않으셨어용</h1>"
					+ "<a href='login/login.jsp'>로그인창으로 이동하기</a></body></html>";
		}
		pw.print(html);
	}

}
