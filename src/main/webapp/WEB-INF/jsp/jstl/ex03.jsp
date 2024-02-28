<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL format library</title>
</head>
<body>
	<h2>JSTL format library</h2>
	
	<h3>1. 숫자 표현</h3>
	<c:set var="number" value="5412489412" />
	<h4><fmt:formatNumber value="${number }" /></h4>
	
	<h3>2. 퍼센트</h3>
	<h4><fmt:formatNumber value="0.31" type="percent" /></h4>
	<h4><fmt:formatNumber value="${3 / 11 }" type="percent" /></h4>
	
	<h3>3. 통화</h3>
	<h4><fmt:formatNumber value="${number }" type="currency" /></h4>
	
	<h3>4. 소수점 표현</h3>
	<c:set var="pi" value="3.141592" />
	<h4>${pi }</h4>
	<h4><fmt:formatNumber value="${pi }" pattern="#.##" /></h4>
	<h4><fmt:formatNumber value="${pi }" pattern="#.########" /></h4>
	<h4><fmt:formatNumber value="${pi }" pattern="0.00000000" /></h4>
	
	<%-- var 변수에 formatNumber로 생성한 값을 저장 --%>
	<fmt:formatNumber value="${pi }" pattern="#.##" var="pi2" />
	<h4>${pi2 * 3 }</h4>
	
	
	<%-- Date now = new Date(); --%>
	<%-- model.addAttribute("now", now); --%>
	<h3>5. 날짜 포맷</h3>
	<h4>${now }</h4>
	
	<%-- 2024년 2월 28일 18:00:12 --%>
	<h4><fmt:formatDate value="${now }" pattern="yyyy년 M월 d일 HH:mm:ss" /></h4>
	
	<c:set var="dateString" value="2024/02/28 18:01:23" />
	<%-- String -> Date --%>
	<fmt:parseDate value="${dateString }" pattern="yyyy/MM/dd HH:mm:ss" var="date" />
	<h4>${date }</h4>
	
	
	
</body>
</html>