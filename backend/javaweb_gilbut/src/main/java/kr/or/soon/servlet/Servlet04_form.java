package kr.or.soon.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet04_form
 */
@WebServlet("/form")
public class Servlet04_form extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet04_form() {
        super();
     
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			String[] web = request.getParameterValues("web");
			for(String s: web) {
				System.out.println("선택한 과목 : "+s);
			}
			System.out.println("id : "+id+ "\n email : "+email+"\n password: "+password);
	}

}
