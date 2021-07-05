<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
fieldset {
	width: 300px;
	margin: auto;
}

div {
	text-align: center;
	margin: 100px auto;
}
</style>
<body>
	<div>
		<form action="login.jsp" method="post">
			<fieldset>
				<legend>로그인</legend>
				<p>
					아이디 : <input type="text" name="id" placeholder="id를 입력하세요"
						required="required">
				</p>
				<p>
					비밀번호 : <input type="password" name="pw"
						placeholder="password를 입력하세요" required="required">
				</p>
				<input type="submit" value="로그인">&nbsp;&nbsp; <input
					type="button" value="회원가입" onclick="join_go(this.form)">
			</fieldset>
		</form>


	</div>
	<script type="text/javascript">
		function join_go(f) {
			f.action = "join.jsp";
			f.submit();
		}
	</script>
</body>
</html>
