<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	int n1 =(Integer)request.getAttribute("n1");
	int n2 =(Integer)request.getAttribute("n2");
	int result =(Integer)request.getAttribute("result");
	
%>
<%=n1 %> + <%=n2 %> = <%=result %> --%>

${n1 }+${n2 } =${result }
</body>
</html>