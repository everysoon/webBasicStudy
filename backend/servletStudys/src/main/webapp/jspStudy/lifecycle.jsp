<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Hello~
<%
	System.out.println("jspService()");

%>
<%! public void jspInit(){
	System.out.println("jspInit()");
}
%>
<%! public void jspDestroy(){
	System.out.println("jspDestroy()");
}
%>
</body>
</html>