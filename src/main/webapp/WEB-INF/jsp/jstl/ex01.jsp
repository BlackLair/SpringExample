<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core library</title>
</head>
<body>
	<h2>JSTL core library</h2>
	
	<h3>1. 변수 만들기</h3>
	
	<%-- int number1 = 100; --%>
	<%-- int number2 = 200; --%>
	<c:set var="number1" value="100" />
	<c:set var="number2">200</c:set>
	
	<h4>숫자 1 : ${number1 }</h4>
	<h4>숫자 2 : ${number2 }</h4>
	
	<h3>2. 태그 그대로 출력하기</h3>
	
	<%-- <script>alert("안녕");</script> --%>
	
	<c:out value="<script>alert('안녕');</script>" />
	<br>
	<%-- escapeXml : 속성 내 특수기호를 html에서 사용할 수 있도록 함. 기본값 : true --%>
	<c:out value="<script>alert('안녕');</script>" escapeXml="true" />
	
	<%--<c:out value="<script>aalert('안녕');</script>" escapeXml="false" /> --%>
	
	<h3>3. 조건문</h3>
	
	<%-- if(true) {} --%>
	<c:if test="true">
		<h4>조건문 결과</h4>
	</c:if>
	
	<%-- if(number1 > 50) { } --%>
	<c:if test="${number1 > 50}">  <%-- test속성에 공백이 들어가지 않도록 한다. --%>
	    <h4>number1이 50보다 크다!</h4>
	</c:if>
	
	<%-- if(number2 == 200) { } --%>
	<%-- 등호/부등호, 및 eq, lt같은 비교수식도 사용할 수 있음 --%>
	<c:if test="${number2 eq 200 }" >
		<h4>number2는 200이다</h4>
	</c:if>
	
	<%-- if(number2 != 200) {} --%>
	<c:if test="${number2 ne 200}">
		<h4>number2는 200이 아니다!!</h4>
	</c:if>
	
	
	<%-- null, 변수가 없다, 리스트가 비어있다, 맵이 비어있다. -> true --%>
	<%-- if(number3 == null) {  } --%>
	<c:if test="${empty number3 }">
		<h4>number3은 비어있다!!</h4>
	</c:if>
	
	<c:if test="${not empty number2 }">
		<h4>number2는 비어있지 않다!</h4>
	</c:if>
	
</body>
</html>