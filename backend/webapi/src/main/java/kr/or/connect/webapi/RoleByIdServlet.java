package kr.or.connect.webapi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import kr.or.connect.jdbc.dao.RoleDAO;
import kr.or.connect.jdbc.dto.Role;

/**
 * Servlet implementation class RoleByIdServlet
 */
@WebServlet("/roles/*")
public class RoleByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RoleByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		
		String pathInfo = request.getPathInfo(); //-> "/roles/{roleId}"
		String[] pathParts = pathInfo.split("/");
		String idStr =pathParts[1];
		int id = Integer.parseInt(idStr);
		
		RoleDAO dao = new RoleDAO();
		Role role = dao.getRole(id);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(role);
		PrintWriter pw = response.getWriter();
		pw.print(json);
		pw.close();
	}

	
}
