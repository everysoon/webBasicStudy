package kr.or.soon.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.soon.dao.MemberDAO_MySql;
import kr.or.soon.dto.Member;

@WebServlet("/loginWithDB")
public class LoginWithDB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Member member = new Member();
		member.setM_id(id);
		member.setM_pwd(password);
		member.setM_name("minsoon");
		member.setM_email("soon@sch.ac.kr");
		member.setM_regDate(String.valueOf(new Date()));
		MemberDAO_MySql dao = new MemberDAO_MySql();
//		dao.addMember(member);
		boolean result = dao.isExisted(member);
		if (result) {
			HttpSession session = request.getSession();
			session.setAttribute("isLogin", true);
			session.setAttribute("login.id", id);
			session.setAttribute("login.password", password);
			pw.print("<html><body><h1>"+id+"님 안녕하세요></h1><a href='show'>회원정보 보기 </a></body></html>");
		}else {
			pw.print("<html><body><h1>회원 아이디가 틀립니다</h1><a href='login/loginSessionWithDB.jsp'>다시 로그인하기 </a></body></html>");
		}
	}

}
