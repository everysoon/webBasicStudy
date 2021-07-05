package exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
@WebServlet("/LifeCycleServlet")
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LifeCycleServlet() {
        super();
        System.out.println("Lifecycle �깮�꽦");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init!");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("destory!!");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<html>");
		out.print("<head><title>form</title></head>");
		// submit 踰꾪듉�씠 �닃�졇�쓣 �븣 action二쇱냼濡� �슂泥��빐二쇱꽭�슂 �씠�븣, �슂泥��씠 �뱾�뼱媛덈븣 硫붿꽌�뱶�뒗 post媛믪쑝濡� �꽔�뼱二쇱꽭�슂
		out.print("<form method='post' action='/ServletStudys/LifeCycleServlet'>" );
		out.print("name : <input type='text' name ='name'><br>");
		out.print("<input type='submit' value='ok'><br>");
		out.print("</form>");
		out.print("</body>");
		out.print("</html>");
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		String name =req.getParameter("name");
		out.print("<h1> hello "+name+" !!</h1>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("service");
//	}

}
