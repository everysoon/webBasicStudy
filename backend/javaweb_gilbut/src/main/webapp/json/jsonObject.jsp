<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#checkJson").click(function(){
		$.ajax({
			type:"post",
			async:false,
			url:"${contextPath}/jsonParse",
			success:function(data,status){
				var jsonInfo = JSON.parse(data); // 서버에서 가져온 데이터 파싱
				var memberInfo ="<h1>회원정보<br>============<br></h1>";
				for(var i in jsonInfo.members){
					memberInfo += "<h2>이름 :"+jsonInfo.members[i].name+"</h2>";
					memberInfo += "<h2>나이 :"+jsonInfo.members[i].age+"</h2>";
					memberInfo += "<h2>성별 :"+jsonInfo.members[i].gender+"</h2>";
					memberInfo += "<h2>닉네임 :"+jsonInfo.members[i].nickname+"</h2>";
					memberInfo += "====================================="
				}
				$("#output").html(memberInfo);
			},
			error:function(data,status){
				alert("에러발생"+status);
			}
		});
	});
});

</script>
</head>
<body>
<input type="button" id="checkJson" value="JSON With Object">
<div id="output"></div>
</body>
</html>