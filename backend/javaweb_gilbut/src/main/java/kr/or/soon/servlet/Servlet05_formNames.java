package kr.or.soon.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/formNames")
public class Servlet05_formNames extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Servlet05_formNames() {
        super();
        // TODO Auto-generated constructor stub
    }

	// request.getParameter("name") 을 사용하기에는 전해받는 파라메터들이 많을 수 있음
    // 그럴땐 request.getParameterNames를 사용하자.
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Enumeration enu = request.getParameterNames();
		while(enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String [] values = request.getParameterValues(name);
			for(String s:values) {
				System.out.println("전해받은 값은 ->  name : "+name+", value:" +s);
			}
		}
	}

}
