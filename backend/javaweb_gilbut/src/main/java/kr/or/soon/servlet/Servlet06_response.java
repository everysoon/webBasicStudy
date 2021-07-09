package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/response")
public class Servlet06_response extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet06_response() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String[] web = request.getParameterValues("web");
		pw.print("<html><body>");
		pw.print("<h1> Servlet06.jsp로 받은 \n id,email,password를 \n HttpServletResponse를 사용해서 화면에 출력하기</h1>");
		pw.print("id : "+id +"<br> email :"+ email+", <br>password :"+password+"<br>");
		for(String s : web) {
			pw.print("받은 checkbox값 : "+s+"<br>");
		}
		pw.print("</body></html>");
	}

}
