package kr.or.soon.json;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


@WebServlet("/jsonParse")
public class JsonParseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/* [JSON배열에 회원정보를 저장하여 JSP페이지로 전송하고 JSON 배열에 정보를 저장하는 과정]
	 * 1. memberInfo로 JSONObject를 생성한 후 회원정보를 nama,value쌍으로 저장
	 * 2. memberArray의 JSONArray객체를 생성한 후 외원정보를 저장한 JSON객체를 저장
	 * 3. totalObject로 JSONObject 객체를 생성해서 name에는 자바스크립트에서 접근할 때 사용하는
	 * 이름 names를, value에는 memebrsArray를 최종 저장
	 * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		
		JSONObject totalObject = new JSONObject(); // JSP에 최종으로 보낼 객체
		JSONObject memberInfo = new JSONObject(); // JSONArray (memebrs) 에 하나씩 넣을 객체
		JSONArray members = new JSONArray();
		memberInfo.put("name", "soon");
		memberInfo.put("age", 25);
		memberInfo.put("gender", "female");
		memberInfo.put("nickname", "minsoon");
		members.add(memberInfo); // 객체 하나 저장
		memberInfo = new JSONObject(); //새로운 객체 생성
		memberInfo.put("name", "min");
		memberInfo.put("age", 26);
		memberInfo.put("gender", "male");
		memberInfo.put("nickname", "minsoonAbo");
		members.add(memberInfo);
		
		totalObject.put("members", members); // JSONArray를 JSONObject로 저장
		String jsonInfo = totalObject.toJSONString(); //문자열로 변환
		System.out.println("totalObject : "+jsonInfo);
		pw.print(jsonInfo); // JSON데이터를 브라우저로 전송
	}

}
