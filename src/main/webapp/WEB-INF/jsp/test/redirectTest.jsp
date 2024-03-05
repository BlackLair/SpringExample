<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Redirect Test</title>
</head>
<body>
	<h2>다음 3가지 방법으로 리다이렉트합니다.</h2>
	<a href="/redirectTest/byResponseEntity">ResponseEntity로 리다이렉트</a><br>
	<a href="/redirectTest/byPrefix">redirect:로 리다이렉트</a><br>
	<a href="/redirectTest/byRedirectView">RedirectView로 리다이렉트</a>
</body>
</html>