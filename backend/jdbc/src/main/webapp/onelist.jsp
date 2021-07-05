<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div {
	text-align: center;
	margin: 100px auto;
}

table, th, td {
	padding: 10px 5px;
	border: 1px solid pink;
	border-collapse: collapse;
	width: 500px;
	margin: auto;
}

input {
	padding: 10px;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function list_go(f) {
			f.action = "list.jsp";
			f.submit();
		}
		function update_go(f) {
			f.action = "update.jsp";
			f.submit();
		}
		function delete_go(f) {
			f.action = "delete.jsp";
			f.submit();
		}
	</script>
	<div>
		<h2>개인정보보기</h2>
		<form method="post">
			<table>
				<tbody>
					<tr>
						<th style="width: 40%">IDX</th>
						<td>${resultP.idx }</td>
					</tr>
					<tr>
						<th>ID</th>
						<td>${resultP.id }</td>
					</tr>
					<tr>
						<th>PW</th>
						<td>${resultP.pw }</td>
					</tr>
					<tr>
						<th>NAME</th>
						<td>${resultP.name }</td>
					</tr>
					<tr>
						<th>AGE</th>
						<td>${resultP.age }</td>
					</tr>
					<tr>
						<th>ADDR</th>
						<td>${resultP.addr }</td>
					</tr>
					<tr>
						<th>REG</th>
						<td>${resultP.reg.substring(0,10) }</td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="2"><input type="button" value="전체보기"
							onclick="list_go(this.form)"> <input type="button"
							value="수정" onclick="update_go(this.form)"> <input
							type="button" value="삭제" onclick="delete_go(this.form)">
							<input type="hidden" name="idx" value="${resultP.idx }">
							<input type="hidden" name="pw" value="${resultP.pw }"></td>
					</tr>

				</tfoot>
			</table>
		</form>

	</div>
</body>
</html>