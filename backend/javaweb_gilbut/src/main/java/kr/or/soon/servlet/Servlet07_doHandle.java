package kr.or.soon.servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/doHandle")
public class Servlet07_doHandle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    // GET 방식과 POST 방식을 모두 처리할 수 있는 doHandle메소드 만들어서 데이터 처리하기
   
    public Servlet07_doHandle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doHandle(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doHandle(request, response);
	}
	private void doHandle(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
			System.out.println("dohandle메소드 호출!");
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			String email= request.getParameter("email");
			String password = request.getParameter("password");
			
		
		
	}

}
