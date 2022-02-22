<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>HELLO SPRING</h1>
	<ul>
		<li><a
			href="ParameterObject01.do?data01=10&data02=20&data03=30&data03=40">ParameterObject01.do</a></li>
		<li><a
			href="ParameterObject02.do?data01=10&data02=20&data03=30&data03=40">ParameterObject02.do</a></li>
	</ul>
	<hr>
	<form method="GET" action="ParameterObject03.do">
		<legend>Member</legend>
		<div><label><span>no</span><input type="text" name="no"></label></div>
		<div><label><span>id</span><input type="text" name="id"></label></div>
		<div><label><span>name</span><input type="text" name="name"></label></div>
		<div><label><span>password</span><input type="text" name="password"></label></div>
		<button>ParameterObject03.do 전송</button>
	</form>
</body>
</html>