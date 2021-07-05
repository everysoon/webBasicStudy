package exam;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogicServlet
 */
@WebServlet("/LogicServlet")
public class LogicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogicServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int n1 = (int)(Math.random()*100)+1;
		int n2 = (int)(Math.random()*100)+1;
		int result = n1 + n2;
		request.setAttribute("n1",n1);
		request.setAttribute("n2",n2);
		request.setAttribute("result",result);
		// jsp로 이동하기때문에 /~.jsp
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jspStudy/result.jsp");
		requestDispatcher.forward(request, response);
	}

}
