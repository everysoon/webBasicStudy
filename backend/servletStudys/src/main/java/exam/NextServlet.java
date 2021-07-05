package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NextServlet
 */
@WebServlet("/NextServlet")
public class NextServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NextServlet() {
		super();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>dice</title></head>");
		out.print("<body>");
		// Object값을 반환하기때문에 Object값으로 받기
		int diceNum = (Integer)request.getAttribute("diceNum");
		out.print("dice : "+diceNum+"<br>");
		for(int i=0; i<diceNum; i++) {
			out.print("<br>Hello");
		}
		out.print("</body>");
		out.print("</html>");
		
		
	
	}

}
