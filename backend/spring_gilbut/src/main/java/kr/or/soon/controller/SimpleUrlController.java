package kr.or.soon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

//@org.springframework.stereotype.Controller
public class SimpleUrlController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		return new ModelAndView("login");
	}

	
//	@RequestMapping( value="/simpleUrl.go", method=RequestMethod.GET)  
//	public ModelAndView goIndex() {
//		return new ModelAndView("/index");
//	}

}
