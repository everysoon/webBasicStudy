<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>servlet07with_js.jsp페이지</h1>
	<form name="formLogin">
		id : <input type="text" name="id"> <br> password : <input
			type="text" name="password"><br> email : <input
			type="text" name="email"><br> <input type="button"
			onclick="myClick()" value="전송">
		<p style="color: red; font-size: '20px';" id="errorMsg">
	</form>
	<script type="text/javascript">
		// form태그의 name속성으로 form태그 객체 받아오기
		var formLogin = document.formLogin;
		console.log(formLogin);
		var errorMsg = document.getElementById("errorMsg");
		function myClick() {
			if ((formLogin.id.value.length == 0) || (formLogin.id.value == "") || (formLogin.password.value.length == 0)
					|| (formLogin.password.value == "")) {
				// 유효성 검사 실패할 경우
				errorMsg.innerHTML = "아이디와 비밀번호는 필수입니당";
			} else {
				errorMsg.innerHTML = "";
				formLogin.method = "post";
				formLogin.action = "doHandle"
				formLogin.submit();
			}
		}
	</script>
</body>
</html>