package kr.or.connect.webapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbc.dao.RoleDAO;
import kr.or.connect.jdbc.dto.Role;

/**
 * Servlet implementation class RolesServlet
 */
@WebServlet("/roles")
public class RolesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public RolesServlet() {
        super();
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		RoleDAO dao = new RoleDAO();
		List<Role> list =dao.getRoles();
		
		// ObjectMapper : json객체라이브러리가 제공해주는 객체
		// json <-> 객체로 바꿔줄수있는 객체
		
		ObjectMapper objectMapper = new ObjectMapper();
		// writeValueAsString : 파라미터를 json문자열로 바꿔 줌 
		String json = objectMapper.writeValueAsString(list);
		
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.close();
	}


}
