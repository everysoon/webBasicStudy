package kr.or.soon.model2;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.soon.dao.MemberDAO_Oracle;
import kr.or.soon.dto.O_Member;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO_Oracle dao = new MemberDAO_Oracle();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (NumberFormatException | ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			doHandle(request, response);
		} catch (NumberFormatException | ServletException | IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, NumberFormatException, ParseException {
		System.out.println("=================doHandle=============");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getPathInfo();
		String nextPage = null;
		System.out.println("action : " + action);
		if (action == null || action.contains("/listMembers.do")) {
			List<O_Member> membersList = dao.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/model2member/listMembers.jsp";
		} else if (action.contains("/addMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			O_Member m = new O_Member(id, pwd, name, email);
			if (dao.addMember(m)) {
				// 추가 성공하면
				request.setAttribute("msg", "addMember");
				nextPage = "/member/listMembers.do";
			}
		} else if (action.contains("/memberForm.do")) {
			nextPage = "/model2member/memberForm.jsp";
		} else if (action.contains("/modMemberForm.do")) {
			String id = request.getParameter("id");
			O_Member m = dao.findMember(id);
			request.setAttribute("memInfo", m);
			nextPage = "/model2member/modMemberForm.jsp";
		} else if (action.equals("/modMember.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String email = request.getParameter("email");
			String name = request.getParameter("name");

			O_Member m = new O_Member(id, pwd, name, email);
			dao.modMember(m);

			// 수정 성공하면
			request.setAttribute("msg", "modified");
			nextPage = "/member/listMembers.do";

		} else if (action.equals("/delMember.do")) {
			String id = request.getParameter("id");
			boolean success = dao.delMember(id);
			if (success) {
				// 삭제 성공하면
				request.setAttribute("msg", "deleted");
				nextPage = "/member/listMembers.do";
			}
		} else {
			List<O_Member> membersList = dao.listMembers();
			request.setAttribute("membersList", membersList);
			nextPage = "/model2member/listMembers.jsp";
		}
		System.out.println("nextPage : " + nextPage);
		request.getRequestDispatcher(nextPage).forward(request, response);

	}

}
