<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
div {
	margin-bottom: 50px;
}

form label span {
	display: inline-block;
	margin: 0 20px;
	width: 80px;
}

form div {
	margin-bottom: 10px;
}
</style>
<body>
	<h1>Form</h1>
	<div>
		<form:form modelAttribute="selectDto" method="POST" action="Result.do">
			<div>
				<form:select path="data01">
					<form:option value="data01">option01</form:option>
					<!-- path에 들어있는 변수의 값(TestController에서 확인 가능)과 option의 value 값이 일치하면 selected 기능 -->
					<form:option value="data02">option02</form:option>
					<form:option value="data03">option03</form:option>
				</form:select>
			</div>
			<div>
				<form:select path="data02">
					<form:options items="${fruitList }" />
				</form:select>
			</div>

			<div>
				<form:select path="data03">
					<form:options items="${animalList }" />
				</form:select>
			</div>
			<div>
				<form:select path="data04">
					<form:options items="${animalList02 }" itemLabel="key"
						itemValue="value" />
				</form:select>
			</div>
			<div>
				<form:checkbox path="data05" value="tigers" />
				기아타이거즈
				<form:checkbox path="data05" value="lions" />
				삼성라이언즈
				<form:checkbox path="data05" value="giants" />
				롯데자이언트
				<form:checkbox path="data05" value="bears" />
				두산베어스
			</div>
			<div>
				<form:checkboxes path="data03" items="${animalList }" />
			</div>
			<div>
				<form:checkboxes path="data04" items="${animalList02 }"
					itemLabel="key" itemValue="value" />
			</div>
		</form:form>
	</div>
</body>
</html>