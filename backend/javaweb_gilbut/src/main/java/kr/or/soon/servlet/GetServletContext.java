package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/GetServletContext")
public class GetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		ServletContext context = getServletContext();
		List list = (ArrayList)context.getAttribute("list");
		String name = (String)list.get(0);
		int age = (int) list.get(1);
		String html = "<html><body>"
				+"<h1>getServletContext예제</h1>"
				+"<h2>getAttribute 사용하기 </h2>"
				+"name : "+name+"<br> age : "+age
				+ "</body></html>";
		writer.print(html);
	}


}
