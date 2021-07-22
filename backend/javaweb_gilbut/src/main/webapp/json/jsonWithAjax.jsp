<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(function(){
	$("#checkJson").click(function(){
		var _jsonInfo ='{"name":"soon",	"age":25,"gender":"여자","nickname":"minsoon"}';
		$.ajax({
			type:"post",
			async:false,
			url:"http://localhost:8090/jsonPrint",
			data:{jsonInfo:_jsonInfo},
			success:function(data,status){
				console.log("data : "+data +", status :"+status);
			},
			error:function(data,status){
				alert('에러발생'+status);
			}
		});
	});
});
</script>
</head>
<body>
<input type="button" id="checkJson" value="jsonWithAjax">
</body>
</html>