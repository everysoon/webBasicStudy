<%@ page language="java" contentType="text/html; charset=UTF-8"
	isELIgnored="false" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	font-size: 40px;
	text-align: center;
}

.cls2 {
	font-size: 20px;
	text-align: center;
}
</style>
</head>
<body>
	<c:choose>
		<c:when test="${msg=='addMember' }">
			<script type="text/javascript">
				window.onload = function() {
					alert("회원등록햇슴다");
				}
			</script>
		</c:when>
		<c:when test="${msg=='modified' }">
			<script type="text/javascript">
				window.onload = function() {
					alert("회원 수정 햇슴다");
				}
			</script>
		</c:when>
		<c:when test="${msg=='deleted' }">
			<script type="text/javascript">
				window.onload = function() {
					alert("회원 삭제 햇슴다");
				}
			</script>
		</c:when>
	</c:choose>
	<p class="cls1">회원 정보</p>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<th width="7%">아이디</th>
			<th width="7%">비밀번호</th>
			<th width="7%">이름</th>
			<th width="7%">이메일</th>
			<th width="7%">가입일</th>
			<th width="7%">수정하기</th>
			<th width="7%">삭제하기</th>
		</tr>

		<c:choose>
			<c:when test="${empty membersList }">
				<tr>
					<td colspan=5><b>등록된 회원이 없습니다.</b></td>
				</tr>
			</c:when>
			<c:when test="${!empty membersList }">
				<c:forEach var="mem" items="${membersList }">
					<tr align="center">
						<td>${mem.m_id }</td>
						<td>${mem.m_pwd }</td>
						<td>${mem.m_name }</td>
						<td>${mem.m_email }</td>
						<td>${mem.m_regDate }</td>
						<td><input type="button"
							onclick="location.href ='${contextPath}/member/modMemberForm.do?id=${mem.m_id}';"
							value="수정"></td>
						<td><input type="button" class="del" 
						onclick="location.href ='${contextPath}/member/delMember.do?id=${mem.m_id}';" value="삭제"></td>
					</tr>
				</c:forEach>
			</c:when>
		</c:choose>
	</table>
	<a href="${contextPath }/member/memberForm.do">
		<p class="cls2">회원가입하기</p>
	</a>
	<script type="text/javascript">
		$(".mod").click(function() {
			location.href = "${contextPath}/member/modMember.do";
		});

		$(".del").click(function() {
			location.href = "${contextPath}/member/delMember.do";
		});
	</script>
</body>
</html>