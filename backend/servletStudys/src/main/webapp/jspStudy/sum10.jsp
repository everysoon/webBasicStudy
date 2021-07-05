<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" content="text/html" http-equiv="Content-Type">
<title>Insert title here</title>
</head>
<body>
	<%
		int total = 0;
		for(int i=1; i<=10; i++){
			total += i;
		}
	%>
 	<p> 1부터 10까지의 합 : <%=total %></p>
</body>
</html>