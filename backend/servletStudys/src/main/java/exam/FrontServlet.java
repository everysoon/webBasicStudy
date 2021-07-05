package exam;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontServlet
 */
@WebServlet("/FrontServlet")
public class FrontServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 서블릿 1번이 주사위를 던지고 저장한 뒤(request에) 
		// 서블릿 2에 넘겨져서 주사위 수 만큼 글자 출력
		int diceNum =(int)(Math.random()*6)+1;
		request.setAttribute("diceNum", diceNum);
		
		//forward 코드
		// 포워드 경로는 무조건 /로 시작 : 어디로 request를 넘길건지 
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/NextServlet");
		requestDispatcher.forward(request, response);
	}



}
