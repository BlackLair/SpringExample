<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사용자 정보 입력</title>
</head>
<body>
	<h2>사용자 추가</h2>

	<label>이름 : </label><input id="input-name" type="text"><br>
	<label>생년월일 : </label><input id="input-birthday" type="text"><br>
	<label>이메일 : </label><input id="input-email" type="text"><button id="btn-duplicate" type="button">중복확인</button><br>
	<label>자기소개</label><br>
	<textarea id="input-introduce" cols="30" rows="7"></textarea><br>
	<button id="btn-add" type="button">추가</button>	

<script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		$("#btn-duplicate").on("click", function(){
			let email = $("#input-email").val();
			if(email == ""){
				alert("이메일을 입력해주세요!");
				return;
			}
			$.ajax({
				type:"get"
				, url:"/ajax/user/duplicated-email"
				, data:{"email":email}
				, success:function(data){
					if(data.isDuplicated){
						alert("이메일이 중복되었습니다!");
					}else{
						alert("사용가능한 이메일 입니다.");
					}
				}, error:function(){
					alert("중복 확인 에러");
				}
				
			});
		});
		
		// 추가 버튼을 클릭하면
		// 사용자가 입력한 내용을 얻어오고
		// ajax를 통해 사용자 추가 API를 요청
		// 응답으로 전달된 값을 통해 다음 과정 처리
		$("#btn-add").on("click", function(){
			let name = $("#input-name").val();
			let birthday = $("#input-birthday").val();
			let email = $("#input-email").val();
			let introduce = $("#input-introduce").val();
			$.ajax({
				type:"get"
				, url:"/ajax/user/create"
				, data:{
					"name":name
					, "birthday":birthday
					, "email":email
					, "introduce":introduce
				}, success:function(data){
					if(data.result == "success"){
						location.href = "/ajax/user/list";
					}else{
						alert("추가 실패");
					}
				}, error:function(){
					alert("추가 에러");
				}
			});
		});
	});
</script>
</body>
</html>