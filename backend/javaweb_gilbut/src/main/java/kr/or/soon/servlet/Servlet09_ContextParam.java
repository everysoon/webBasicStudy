package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/initMenu")
public class Servlet09_ContextParam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Servlet09_ContextParam() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		ServletContext context = getServletContext();
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		
		String html ="<html><body><table border=1 cellspacing=0><tr>메뉴 이름</tr>"
				+" <tr><td>"+menu_member+"</td></tr>"
				+" <tr><td>"+menu_order+"</td></tr>"
				+" <tr><td>"+menu_goods+"</td></tr>"
				+ "</table></body></html>";
		pw.print(html);
	}
	

}
