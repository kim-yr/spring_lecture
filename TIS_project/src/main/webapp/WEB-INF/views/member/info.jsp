<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../include/header.jsp"%>
<main id="main">
	<div class="contents">
		<div class="title">
			<h1>
				<a href="../member/List.do">원생 관리</a><span class="depth"> >
					정보 조회</span>
			</h1>
		</div>
		<div class="inner">
			<div class="info">
				<table>
					<colgroup>
							<col style="width: 20%" />
							<col style="width: 80%" />
					</colgroup>
					<tr>
						<th>이름</th>
						<td>${memberDto.name }</td>
					</tr>
					<tr>
						<th>분류</th>
						<c:if test="${memberDto.position eq 'S' }">
							<td>학생</td>
						</c:if>
						<c:if test="${memberDto.position eq 'T' }">
							<td>강사</td>
						</c:if>
						<c:if test="${memberDto.position eq 'F' }">
							<td>직원</td>
						</c:if>
					</tr>
					<tr>
						<th>아이디</th>
						<td>${memberDto.id }</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${memberDto.tell }</td>
					</tr>
					<tr>
						<th>이메일</th>
						<td>${memberDto.email }</td>
					</tr>
					<tr>
						<th>과목</th>
						<c:if test="${memberDto.subject eq 'first' }">
							<td>1강의실: 프론트엔드 개발자 양성과정</td>
						</c:if>
						<c:if test="${memberDto.subject eq 'second' }">
							<td>2강의실: 백엔드 개발자 양성과정</td>
						</c:if>
						<c:if test="${memberDto.subject eq 'third' }">
							<td>3강의실: 풀스택 개발자 양성과정</td>
						</c:if>
						<c:if test="${memberDto.subject eq 'fourth' }">
							<td>4강의실: 퍼블리셔 양성과정</td>
						</c:if>
						<c:if test="${memberDto.subject eq 'fifth' }">
							<td>5강의실: 인공지능 개발자 양성과정</td>
						</c:if>
						<c:if test="${memberDto.subject eq 'sixth' }">
							<td>6강의실: 데이터 엔지니어 양성과정</td>
						</c:if>
					</tr>
					<tr>
						<th>등록일</th>
						<fmt:parseDate value="${memberDto.regDate }" var="convertDate"
							pattern="yyyy-MM-dd HH:mm:ss" />
						<td><fmt:formatDate value="${convertDate }"
								pattern="yyyy년 M월 d일" /></td>
					</tr>
				</table>
			</div>
		</div>
		<div class="btns">
			<a href="../member/List.do" class="btn">뒤로 가기</a> <a
				href="../member/Delete.do?code=${memberDto.code }"
				class="btn delete">삭 제</a> <a
				href="../member/InfoUpdate.do?code=${memberDto.code }"
				class="btn update">정보 수정</a>
		</div>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>