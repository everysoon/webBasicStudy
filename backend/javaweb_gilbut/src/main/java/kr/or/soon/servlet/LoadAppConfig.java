package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns ={"/loadConfig"},name="loadConfig",loadOnStartup = 1)
public class LoadAppConfig extends HttpServlet {
	// load-on-startup
	// 서블릿은 브라우저에서 최초 요청 시 init() 메서드를 실행한 후 메모리에 로드되어 기능을 수행
	// -> 최초요청에 대해서는 실행시간이 길어질 수 밖에 없음 
	// : 이런 단점을 보완하기 위햇 load-on-startup 사용 (web.xml에 설정방법과 에너테이션 이용방법 두가지 있음)
	// 1. 톰캣 컨테이너가 실행되면서 미리 서블릿을 실행
	// 2. 지정한 숫자가 0보다 크면 톰캣 컨테이너가 실행되면서 서블릿이 초기화 됨.
	// 3. 지정한 숫자는 우선순위를 의미하며 작은 숫자부터 먼저 초기화 
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출!");
		// ServletContext객체 얻기
		context =config.getServletContext();
		// getInitParameter로 web.xml의 contextParam을 읽음
		String menu_member = context.getInitParameter("menu_member");
		String menu_order = context.getInitParameter("menu_order");
		String menu_goods = context.getInitParameter("menu_goods");
		// 메뉴정보를 ServletContext에 바인딩
		context.setAttribute("member", menu_member);
		context.setAttribute("order", menu_order);
		context.setAttribute("goods", menu_goods);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String member =(String) context.getAttribute("member");
		String order =(String) context.getAttribute("order");
		String goods =(String) context.getAttribute("goods");
		String html = "<html><body>"
				+ "<p>member : "+member+"</p>"
				+ "<p>order : "+order+"</p>"
				+ "<p>goods : "+goods+"</p>"
				+ "</body></html>";
		pw.print(html);
	}

}
