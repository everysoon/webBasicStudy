package kr.or.connect.guestbook.argumentresolver;

import java.util.Iterator;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HeaderMapArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		// 인자의 정보를 파라메터로 정보
		// 해당 파라메터에 원하는 정보있으면 true 반환
		return parameter.getParameterType() == HeaderInfo.class;
	}
	// resolveArgument : supportsParameter가 true일경우에만 호출됨
	// resolveArgument가 리턴한 값은 컨트롤러 메소드의 인자로 전달
	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		// 요청으로 넘어온 모든 헤더정보를 Headerinfo에 담아 전달
		HeaderInfo headerInfo = new HeaderInfo();
		Iterator<String> names = webRequest.getHeaderNames();
		while(names.hasNext()) {
			String headerName = names.next();
			String headerValue = webRequest.getHeader(headerName);
			headerInfo.put(headerName, headerValue);
		}
		return headerInfo;
	}

	
}
