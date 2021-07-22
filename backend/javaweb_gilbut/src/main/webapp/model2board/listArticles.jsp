<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.cls1 {
	text-decoration: none;
}

.cls2 {
	text-align: center;
	font-size: 40px;
}
</style>
</head>
<body>
	<table align="center" border="1" width="80%">
		<tr height="10" align="center" bgcolor="pink">
			<th>글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
		</tr>
		<c:choose>
			<c:when test="${empty articles }">
				<tr height="10">
					<td colspan="4"><p align="center">
							<b><span style="font-size: 9pt">아직 등록된 글이 없습니다.</span></b>
						</p></td>
				</tr>
			</c:when>
			<c:when test="${!empty articles }">
				<c:forEach var="a" items="${articles}" varStatus="articleNumber">
					<tr align="center">
						<td width="5%">${articleNumber.count }</td>
						<td width="10%">${a.m_id }</td>
						<td align="left" width="35%"><span
							style="padding-right: 30px"></span>
							 <c:choose>
								<c:when test="${a.level>1 }">
									<c:forEach begin="1" end="${a.level }" step="1">
										<span style="padding-left: 20px;"></span>
									</c:forEach>
									<span style="font-size: 12px">[답변]</span>
									<a class="cls1"
										href="${contextPath }/board/viewArticle.do?articleNO=${a.articleNO}">${a.title }</a>
								</c:when>
								<c:otherwise>
									<a class="cls1"
										href="${contextPath }/board/viewArticle.do?articleNO=${a.articleNO}">${a.title }</a>
								</c:otherwise>
							</c:choose>
							</td>
						<td width="10%"><fmt:formatDate value="${a.writedate }" /></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a class="cls1" href="${contextPath }/board/articleForm.do"><p class="cls2">글쓰기</p></a>
</body>
</html>