package com.example.core.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.core.common.MyLogger;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
	private final LogDemoService logDemoService;
	private final MyLogger myLogger;

	@RequestMapping("log-demo")
	@ResponseBody
	public String logDemo(HttpServletRequest request) {
//		MyLogger myLogger = myProvider.getObject();
		myLogger.setRequestURL(request.getRequestURI());
		myLogger.log("controller !");

		logDemoService.logic("testId");
		return "OK";
	}

}
