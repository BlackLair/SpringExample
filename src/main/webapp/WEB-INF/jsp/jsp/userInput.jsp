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
	<form method="post" action="/jsp/user/create">
		<label>이름 : </label><input name="name" type="text"><br>
		<label>생년월일 : </label><input name="birthday" type="text"><br>
		<label>이메일 : </label><input name="email" type="text"><br>
		<label>자기소개</label><br>
		<textarea name="introduce" cols="30" rows="7"></textarea><br>
		<button type="submit">추가</button>	
	</form>

</body>
</html>