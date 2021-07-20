package kr.or.soon.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Ajax02")
public class Ajax02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/xml");
		String result = "";
		PrintWriter pw = response.getWriter();
		result = "<main>"
				+ "<book>"
				+ "<title><![CDATA[초보자를 위한 자바 프로그래밍]]></title>"
				+"<writer><![CDATA[인포북스 저|이병승]]></writer>"
				+"<image><![CDATA[http://localhost:8090/img/java.jpg]]></image>"
				+"</book>"
				+"<book>"
				+ "<title><![CDATA[모두의 파이썬]]></title>"
				+"<writer><![CDATA[길벗 저 |이승찬]]></writer>"
				+"<image><![CDATA[http://localhost:8090/img/python.jpg]]></image>"
				+ "</book>"
				+ "</main>";
//		request.setAttribute("book",result);
//		request.getRequestDispatcher("ajax/ajax02.jsp").forward(request, response);
		pw.print(result);
	}
	

}
