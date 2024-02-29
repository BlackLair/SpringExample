<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL function library</title>
</head>
<body>
	<h2>JSTL function library</h2>
	<hr>
	<c:set var="string1" value="No pain No gain" />
	<h4>"${string1 }"</h4>
		
	<h3>1. 문자열 길이</h3>

	<h4>길이 : ${fn:length(string1) }</h4>
	
	<h3>2. 특정 문자열을 포함하는 여부 확인</h3>
	<h4>"No"를 포함하는가? ${fn:contains(string1, "No") } </h4>
	
	<c:if test="${fn:contains(string1, 'No') }">
		<h4>No가 포함되었다.</h4>
	</c:if>
	
	<h3>3. 특정 문자열로 시작, 끝나는 여부 확인</h3>
	<h4>No로 시작하는가? ${fn:startsWith(string1, "No") }</h4>
	<h4>gain으로 끝나는가? ${fn:endsWith(string1, "gain") }</h4>
	
	<hr>
	<c:set var="string2" value="I love chicken" />
	<h4>"${string2 }"</h4>
	
	<h3>4. 문자열 치환</h3>
	<h4>변환 : ${fn:replace(string2, "chicken", "pizza") }</h4>
	<h4>원본 : ${string2 }</h4>
	
	<h3>5. 문자열 자르기</h3>
	<h4>${fn:substring(string2, 2, 6) }</h4>
	
	<h3>6. 문자열 쪼개기</h3>
	<h4>${fn:split(string2, " ")[2] }</h4>
	<c:set var="temp" value="${fn:split(string2, ' ')}" />
	<h4>${temp[1] }</h4>
	
	<hr>
	<c:set var="string3" value="    hello      " />
	<textarea>${string3 }</textarea>
	
	<h3>7. 문자열 앞뒤 공백 제거</h3>
	<textarea>${fn:trim(string3) }</textarea>
	
</body>
</html>