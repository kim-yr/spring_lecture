<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
	div {margin-bottom:50px;}
	form label span {display:inline-block;margin: 0 20px;width:80px;}
	form div {margin-bottom: 10px;}
</style>
<body>
	<h1>Form</h1>
	<div>
		<form:form modelAttribute="boardDto" method="POST" action="Result.do">
			<div><label><span>no : </span><form:input path="no" /></label></div> <!-- 닫는 태그 슬래시 꼭 써줘야 함 -->
			<div><label><span>subject : </span><form:input path="subject" /></label></div>
			<div><label><span>password : </span><form:password path="password" showPassword="true" /></label></div>
			<div><label><span>regdate : </span><form:input path="regdate" /></label></div>
			<div><label><span>hit : </span><form:input path="hit" /></label></div>
			<button>전송</button>
		</form:form>
	</div>
</body>
</html>