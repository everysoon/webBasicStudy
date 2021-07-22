package kr.or.soon.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.soon.dao.MemberDAO_MySql;
import kr.or.soon.dto.Member;

@WebServlet("/jdbc")
public class Servlet08_JDBC extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		MemberDAO_MySql dao = new MemberDAO_MySql();
		
		List<Member> mList = dao.getListMemebers();
		PrintWriter pw = resp.getWriter();
		pw.print("<html><body>");
		pw.print("<table><tr><th>idx</th><th>id</th><th>pwd</th><th>name</th><th>email</th><th>regDate</th></tr>");
		for(Member m : mList) {
			pw.print("<tr>");
			pw.print("<td>"+m.getM_idx()+"</td>");
			pw.print("<td>"+m.getM_id()+"</td>");
			pw.print("<td>"+m.getM_pwd()+"</td>");
			pw.print("<td>"+m.getM_name()+"</td>");
			pw.print("<td>"+m.getM_email()+"</td>");
			pw.print("<td>"+m.getM_regDate()+"</td>");
			pw.print("</tr>");
		}
		pw.print("</table>");
		pw.print("</body></html>");
		
	}

	
}
