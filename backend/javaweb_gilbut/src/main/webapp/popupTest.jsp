<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

console.log("1");
function pageLoad(){
	notShow = getCookieValue();
	console.log("2");
	if(notShow!="true"){
		console.log("3");
		window.open("popup.jsp","pop","width=300,height=300,history=no,resizable=yes,status=no,scrollbars=yes,menubar=no");
		console.log("4");
	}
}
function getCookieValue(){
	console.log("5");
	var result ="false";
	if(document.cookie!= ""){
		
		var cookie = document.cookie.split(";");// document의 cookie속성으로 쿠키 정보를 문자열로 가져오고 세미콜론으로 분리
		for(var i =0; i<cookie.length; i++){
			console.log("7");
			element = cookie[i].split("="); 
			value =element[0];
			value = value.replace(/^\s*/,''); // 정규식을 이용해 쿠키 이름 문자열에 공백 제거
			if(value == "notShow"){
				console.log("8");
				result = element[1];
			}
		}
		return result;
	}
}
function deleteCookie(){
	document.cookie = "notShow="+"false"+";path=/;expires=-1";
}
window.onload = pageLoad(); // 웹페이지 로드될때 pageLoad()함수 호출
</script>
</head>
<body>
<h1>자바스크립트에서 쿠키사용</h1>
<form>
<input type="button" value="쿠키삭제" onclick="deleteCookie()">
</form>
</body>
</html>