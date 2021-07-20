<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function setPopup(obj){
	if(obj.checked==true){
		// 팝업 띄우지않기가 true
		console.log("7");
		var expireDate =new Date();
		var days = 1; // 쿠키 유효기간을 하루로 설정
		expireDate.setDate(expireDate.getDate()+days);// 쿠키 유효기간을 하루로 설정
		document.cookie="notShow="+"true"+";path=/;expires="+expireDate.toGMTString(); // 오늘 더이상 팝업 띄우지 않기 체크하면 notShow쿠키값을 true로 설정해서 팝업 띄우지않기
		window.close();
	}
}
</script>
</head>
<body>
<h1>알림 팝업창!</h1>
<form>
	<input type="checkbox" onclick="setPopup(this)">오늘 더이상 팝업 띄우지 않귀~
</form>
</body>
</html>