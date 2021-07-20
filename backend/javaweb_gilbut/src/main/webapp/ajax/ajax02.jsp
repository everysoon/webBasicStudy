<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<script type="text/javascript">
		function ajaxFunc() {
			$.ajax({
				type : "post",
				dataType : "xml",
				async : false,
				url : "http://localhost:8090/Ajax02",
				success : function(info, status) {
					$(info).find("book").each(function(){
						var title = $(this).find("title").text();	
						var writer = $(this).find("writer").text();	
						var image = $(this).find("image").text();
						$("#bookInfo").append("<p>"+title+"</p>"+"<p>"+writer+"</p>"+"<img width=300 height=400 src="+image+"></p>");
					});
				},
				error : function(data, status) {
					alert("에러 발생"+status);
				},
				complete : function(data, status) {
					alert("작업 완료"+status);
				}
			});
		}
	</script>
	<input type="button" value="전송하기" onclick="ajaxFunc()"><br>
	<h1 id="bookInfo"></h1>
</body>
</html>