package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ServletConfig는 각 Servlet객체에 대해 생성
//javax.servlet.servletconfig
//각 서블릿에서만 접근할 수 있고 공유는 불가능
//1. ServletContext 객체를 얻는 기능 2. 서블릿에 대한 초기화 작업 기능이 있다.
//서블릿 초기화하려면 @WebServlet을 이용하는방법과 web.xml에 설정하는 방법이 있다.

/*
* @webServlet 구성 요소
* 1. urlPatterns : 웹 브라우저에서 서블릿 요청 시 사용하는 매핑이름
* 2. name : 서블릿 이름
* 3. loadOnStartup : 컨테이너 실행 시 서블릿이 로드되는 순서 지정
* 4. initParams : @WebinitParam 에너테이션을 이용해 매개변수를 추가하는 기능
* 5. description : 서블릿에 대한 설명
*/
@WebServlet(
		urlPatterns = { 
				"/webServletConfig", 
				"/webServletConfig2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "minsoon@naver.com", description = "soonEmail"), 
				@WebInitParam(name = "tel", value = "010-9916-1269", description = "soonPhonNumber")
		})
public class ServletConfig extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		String html = "<html><body><p>email :"+email + "</p> <p>tel : "+ tel +"</p></body></html>";
		pw.print(html);
	}

}
