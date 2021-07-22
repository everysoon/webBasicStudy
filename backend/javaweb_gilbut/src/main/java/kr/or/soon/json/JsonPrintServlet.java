package kr.or.soon.json;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

@WebServlet("/jsonPrint")
public class JsonPrintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
		System.out.println("post호출");
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doHandle호출");
		String jsonInfo = request.getParameter("jsonInfo");
	
		try {
			 JSONParser parser = new JSONParser();
			 JSONObject obj = (JSONObject) parser.parse(jsonInfo);
			 System.out.println("*회원정보*");
			 System.out.println("name : "+obj.get("name"));
			 System.out.println("age : "+obj.get("age"));
			 System.out.println("gender : "+ obj.get("gender"));
			 System.out.println("nickname : "+obj.get("nickname"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
