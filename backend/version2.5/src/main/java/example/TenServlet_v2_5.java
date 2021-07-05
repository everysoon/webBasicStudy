package example;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ex01
 */
public class TenServlet_v2_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// Servlet 3.0 미만은 web.xml에 꼭 명시해줘야 함.
	// 3.0이상은 어노테이션이 대신 해 줌!
	
	// web.xml을 살펴보면 servlet-mapping이 추가된 것을 볼 수 있다.
	// -> url-pattern이  이 페이지가 열어짐.
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TenServlet_v2_5() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.print("<h1> 1 - 10까지 출력 </h1>");
		for(int i=1; i<=10; i++) {
			pw.print(i+"<br>");
		}
		pw.close();
	}



}
