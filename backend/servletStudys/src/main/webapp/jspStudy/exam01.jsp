<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!--  <%! %> : 메소드나 변수 선언 -->
id : <%=getID() %>
<%!
	String id = "u001"; //변수 선언
	public String getID(){
		return id; // 메소드 선언
	}
%>
</body>
</html>