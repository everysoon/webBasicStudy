<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join my WebSite</h1>
	<div class="formWrap" enctype="multipart/form-data">
		<form action="/join" method="post" id="myForm">
			<div class="inputWrap">
				<div class="email">
					<span>Email</span> <input type="text" name="email"><br>
				</div>
				<div class="password">
					<span>Password</span><input type="password" name="pwd"><br>
				</div>
			</div>
			<span>fileUpload</span><input type="file" name="fileImg"
				id="fileOpenInput" accept="image/*"> <input type="submit"
				value="확인" class="sendBtn">
		</form>
		<div class="imgWrap">
		<img width="100" style="display:none" class="thumb_img"> 
		
		</div>
	</div>
	<section class="result"></section>
	<script>
	//파일 확장자 검사는 accept속성을 사용해서 할 수있지만 이 방법이 더 깔끔!
	function validImageType(img){
		var result =(['image/jpeg','image/png','image/jpg'].indexOf(img.tpye)>-1);
		return result;
	}
	var elImg = documnet.querySelector("#fileOpenInput");
	elImg.addEventListener("change",function(evt){
		var img = evt.target.files[0];
		if(!validImageType(Img)){
			console.log("invalide image file type");
			return;
		}
		// 이렇게 넣으면 이미지 정보 화면에 노출 시키기 : 썸네일
		var elImg=document.querySelector(".thumb_img");
		elImg.style.display = "inline-block";
		elImg.src = window.URL.createObjectURL(img);
	});
	</script>
</body>
</html>