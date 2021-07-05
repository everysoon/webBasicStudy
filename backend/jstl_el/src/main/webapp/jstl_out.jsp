<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- out은 jspWriter에 데이터를 출력한다 -->
    <%-- 문법 : <c:out value="value" escapeXml="{true|false}" default="defaultValue"> --%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var ="t" value="<script type='text/javascript'>alert(0);</script>"></c:set>
<%-- ${t } --%>
<!-- value : JspWriter에 출력할 값 -->
<!-- escapeXml : true일땐 그냥 문자처럼 쭉 나옴(기본값은 true) -->
<c:out value="${t }" escapeXml="false"></c:out>
</body>
</html>