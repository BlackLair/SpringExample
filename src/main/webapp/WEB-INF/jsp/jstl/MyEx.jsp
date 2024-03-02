<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL function Library</title>
</head>
<body>
<c:set var="string1" value="     이것이 문자열이다.    " />
<textarea cols="25">${string1 }</textarea>
<h4>문자열 앞뒤 공백 제거</h4>
<textarea cols="25">${fn:trim(string1) }</textarea>
</body>
</html>