<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL Format Library</title>
</head>
<body>
	<c:set var="dateString" value="21시 05분 23초 / 2024년 02월 28일" />
	<fmt:parseDate var="date" value="${dateString }" pattern="HH시 mm분 ss초 / yyyy년 MM월 dd일" />
	${date } <br><br>

	<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss" /><br>
	<fmt:formatNumber value="${43 / 131 }" type="percent" pattern="0.0000000%" />
</body>
</html>