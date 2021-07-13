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


@WebServlet("/SetServletContext")
public class SetServletContext extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//ServletContext : 각 어플리케이션(컨텍스트)마다 한개의 ServletContext 객체 생성
	// 서블릿 컨테이너와 통신하기위해 사용되는 메소드를 지원하는 인터페스이다. (서블릿끼리 자원공유)
	/*
	 * getServletContext()메서드를 이용해 ServletContext 객체에 접근한 뒤,
	 * ArrayList 에 이름과 나이를 저장한 후 다시 ServletContext객체에 setAttribute메서드를 이용해 바인딩
	 * -> GetServletContext에서 꺼내 사용해보자.
	 * */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		ServletContext context = getServletContext();
		List list = new ArrayList<>();
		list.add("soon");
		list.add(25);
		context.setAttribute("list", list);
		writer.print("<html><body>");
		writer.print("<h1>ServletContext예제</h1>");
		writer.print("<h2>setServletContext : setAttribute</h2>");
		writer.print("soon 25살 설정");
		writer.print("<a href='/GetServletContext'>GetServletContext로 이동하기</a>");
		writer.print("</body></html>");
		
	}


}
