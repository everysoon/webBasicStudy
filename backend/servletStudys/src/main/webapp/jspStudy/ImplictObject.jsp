<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 내장객체 알아보기
	1. request : HTML form 요소 선택값과 같은 사용자 입력 정보를 읽어올 때 사용
	2. response : 사용자요청에 대한 응답을 처리할 때 사용
	3. out : 사용자에게 전달하기위한 output 스트림을 처리하기 위해 사용
	4. application : 웹 서버의 애플리케이션 처리와 관련된 정보를 참조하기 위해 사용
	5. page : 현재 JSP페이지에 대한 클래스 정보
	6. session :클라이언트 세션 정보를 처리하기 위해 사용
	7. pageContext : 현재 JSP실행에 대한 context 정보를 참조하기위해 사용
	8. config : 현재 JSP에 대한 초기화 환경을 처리하기위해 사용
	9.exception : 예외처리위해 사용 
 --%>
<%
	StringBuffer url = request.getRequestURL();
	out.print("url : "+url.toString()+"<br>");
%>
</body>
</html>