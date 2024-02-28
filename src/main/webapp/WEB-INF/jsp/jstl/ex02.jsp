<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core 제어문</title>
</head>
<body>
	<h2>JSTL core 제어문</h2>
	
	<h3>1. if, else if</h3>
	<%-- 몸무게가 70 이하면 치킨, 80 이하면 샐러드, 그게 아니면 굶는다 --%>
	<c:set var="weight" value="99" />
	
	<c:choose>
		<c:when test="${weight <= 70 }">
			<h4>치킨</h4>
		</c:when>
		<c:when test="${weight <= 80 }">
			<h4>샐러드</h4>
		</c:when>
		<c:otherwise>
			<h4>굶어!</h4>
		</c:otherwise>
	</c:choose>
	
	<h3>2. 반복문</h3>
	<%-- for(int i = 0; i < 5; i++){ } --%>
	<%-- n회 반복의 형식은 잘 사용되지 않음. --%>
	<c:forEach var="i" begin="0" end="4" step="1">
		${i }
	</c:forEach>
	
	<%-- for(String fruit : fruitList){ } --%>
	<%-- status : 반복 상태를 확인할 수 있는 변수 --%>
	<c:forEach var="fruit" items="${fruitList }" varStatus="status">
		<h4>${fruit } :: ${status.count }, ${status.index }, ${status.first }, ${status.last } </h4>
	</c:forEach>
	
	<h3>사용자 리스트</h3>
	<table border="1">
		<thead>
			<tr>
				<th>이름</th>
				<th>나이</th>
				<th>취미</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="member" items="${memberList }">
			<tr>
				<td>${member.name }</td>
				<td>${member.age }</td>
				<td>${member.hobby }</td>
			</tr>
			</c:forEach>
		</tbody>
	
	</table>
	
</body>
</html>