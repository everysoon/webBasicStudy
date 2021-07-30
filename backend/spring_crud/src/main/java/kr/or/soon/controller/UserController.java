package kr.or.soon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

public class UserController extends MultiActionController{
	/* MultiCationController */
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ModelAndView mav= new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String id = "";
		String password = "";
		id = request.getParameter("id");
		password = request.getParameter("password");
		mav.addObject("id", id);
		mav.addObject("password",password);
		mav.setViewName("loginComplete");
		return mav;
	} 
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ModelAndView mav= new ModelAndView();
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String addr = request.getParameter("addr");
		String name = request.getParameter("name");
		mav.addObject("id", id);
		mav.addObject("password",password);
		mav.addObject("email",email);
		mav.addObject("addr",addr);
		mav.addObject("name",name);
		mav.setViewName("memberInfo");
		return mav;
	}
}
