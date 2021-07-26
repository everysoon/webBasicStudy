package kr.or.soon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;

import kr.or.soon.dto.Member;
import kr.or.soon.service.MemberService;

public class MemberControllerImpl implements MemberController{
	private MemberService service;
	// 주입하기 위해 Setter를 꼭 구현해야함.
		public void setService(MemberService service) {
			this.service = service;
		}

		public ModelAndView listMembers(HttpServletRequest request, HttpServletResponse response) throws Exception {
			String viewName = getViewName(request); // 요청받은 url 중에 .do 앞에부분을 떼서 뷰네임으로 얻어내기
			List<Member> members = service.listMembers();
			ModelAndView mav = new ModelAndView(viewName);
			mav.addObject("membersList", members);
			return mav;
		}

		@Override
		public ModelAndView removeMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
			service.removeMember(id);
			ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
			return mav;
		}
		public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception{
			String viewName = getViewName(request);
			ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
			return mav;
		}
		@Override
		public ModelAndView addMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			Member member = new Member();
			 bind(request,member);
			int result = 0;
			result = service.addMember(member);
			ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
			return mav;
		}
		@Override
		public ModelAndView modMember(HttpServletRequest request, HttpServletResponse response) throws Exception {
			request.setCharacterEncoding("utf-8");
			Member member = new Member();
			bind(request,member);
			int result = 0;
			result = service.modMember(member);
			ModelAndView mav = new ModelAndView("redirect:/member/listMembers.do");
			return mav;
		}
		public String getViewName(HttpServletRequest request) {
			String contextPath = request.getContextPath();
			String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
			if (uri == null || uri.trim().equals("")) {
				uri = request.getRequestURI();
			}
			int begin = 0;
			if (!(contextPath == null) || (contextPath.equals(""))) {
				begin = contextPath.length();
			}
			int end;
			if (uri.indexOf(";") != -1) {
				end = uri.indexOf(";");
			} else if (uri.indexOf("?") != -1) {
				end = uri.indexOf("?");
			} else {
				end = uri.length();
			}

			String fileName = uri.substring(begin, end);
			if (fileName.indexOf(".") != -1) {
				fileName = fileName.substring(0, fileName.lastIndexOf("."));
			}

			if (fileName.lastIndexOf("/") != -1) {
				fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
			}
			return fileName;
		}

	
		public void bind(HttpServletRequest request,Member m) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String password = request.getParameter("password");
			m.setM_id(id);
			m.setM_pwd(password);
			m.setM_email(email);
			m.setM_name(name);
		}

	

}
