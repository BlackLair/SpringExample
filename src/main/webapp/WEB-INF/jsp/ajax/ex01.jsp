<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX 예제</title>
</head>
<body>
	<h2>AJAX 예제</h2>
	<button id="requestBtn" type="button">요청</button>
	<div id="nameDiv"></div>
	<div id="ageDiv"></div>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			$("#requestBtn").on("click", function(){
				$.ajax({
					type:"get"
					, url:"/ajax/person"
					, data:{"name":"홍길동", "birthday":"20020421"}
					, success:function(data){
						// {"name":"홍길동", "age":23}
						// ajax는 response로 돌아온 body가 json형태라면 javascript 객체로 변환하여 data로 저장한다.
						//alert("나이 : " + data.age);
						$("#nameDiv").text(data.name);
						$("#ageDiv").text(data.age);
					}, error:function(){
						alert("에러!!");
					}
				});
			});
		});
	</script>
</body>
</html>