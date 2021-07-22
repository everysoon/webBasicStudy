package kr.or.soon.servlet;

//@WebFilter("/*") //모든 요청에 수행하도록 * 표시
//// 사용자 정의 필터는 무조건 Filter인터페이스를 구현해야함.
//public class EncodingFilter implements Filter {
//
//    /*
//     * 브라우저 요청 시 doFilter() 메소드의 매개변수로 request와 response 전달
//     * 전달된 request를 이용해 한글 인코딩 작업
//     * */
//	ServletContext context;
//	
//    public EncodingFilter() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see Filter#destroy()
//	 */
//	public void destroy() {
//		System.out.println("destory 호출");
//	}
//
//	/**
//	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
//	 */
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//		System.out.println("doFilter 호출");
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		String context =((HttpServletRequest)request).getContextPath();
//		String pathInfo = ((HttpServletRequest)request).getRequestURI();
//		String realPath = request.getRealPath(pathInfo);
//		String msg = "Context 정보 :"+context+"\n URI정보 : "+pathInfo+"\n 물리적경로 : "+realPath;
//		System.out.println(msg);
//		chain.doFilter(request, response);//다음 필터로 넘기기 
//	}
//
//	/**
//	 * @see Filter#init(FilterConfig)
//	 */
//	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("utf-8 인코딩~");
//		context=fConfig.getServletContext();
//		
//	}

//}
