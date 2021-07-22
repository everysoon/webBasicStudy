<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("#checkJson").click(function(){
		var jsonStr = '{"name":["soon","min","park"]}';
		var jsonInfo =JSON.parse(jsonStr);
		var output ="회원 이름<br>";
		output+="============<br>";
		for(var i in jsonInfo.name){
			output+=jsonInfo.name[i]+"<br>";
		}
		$("#output").html(output);
	});
});
</script>
</head>
<body>
<input type="button" id="checkJson" value="json">
<h1 id="output"></h1>
</body>
</html>