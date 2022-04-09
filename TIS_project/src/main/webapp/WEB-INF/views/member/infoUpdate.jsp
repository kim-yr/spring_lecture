<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main id="main">
	<div class="contents">
		<div class="title">
			<h1>
				<a href="../member/List.do">원생 관리</a><span> > 정보 수정</span>
			</h1>
		</div>
		<form action="../member/InfoUpdateProcess.do" method="POST">
			<div class="inner">
				<div class="info">
					<table>
						<colgroup>
							<col style="width: 20%" />
							<col style="width: 80%" />
						</colgroup>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" id="name"
								value="${memberDto.name }" /></td>
						</tr>
						<tr>
							<th>분류</th>
							<td><select name="position" id="position">
									<option value=null>전체</option>
									<c:if test="${memberDto.position eq 'S' }">
										<option value="S" selected>원생</option>
										<option value="T">강사</option>
										<option value="F">직원</option>
									</c:if>
									<c:if test="${memberDto.position eq 'T' }">
										<option value="S">원생</option>
										<option value="T" selected>강사</option>
										<option value="F">직원</option>
									</c:if>
									<c:if test="${memberDto.position eq 'F' }">
										<option value="S">원생</option>
										<option value="T">강사</option>
										<option value="F" selected>직원</option>
									</c:if>
							</select></td>
						</tr>
						<tr>
							<th>아이디</th>
							<td><input type="text" name="id" id="user_id"
								value="${memberDto.id }" readonly></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" name="password" id="user_pw"
								placeholder="비밀번호를 입력하세요."></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><select name="tellFirst" class="short tell">
									<c:if test="${memberDto.tellFirst eq '010' }">
										<option value="010" selected>010</option>
										<option value="011">011</option>
										<option value="02">02</option>
									</c:if>
									<c:if test="${memberDto.tellFirst eq '011' }">
										<option value="010">010</option>
										<option value="011" selected>011</option>
										<option value="02">02</option>
									</c:if>
									<c:if test="${memberDto.tellFirst eq '02' }">
										<option value="010">010</option>
										<option value="011">011</option>
										<option value="02" selected>02</option>
									</c:if>
							</select> - <input type="number" name="tellMiddle" id="tellMiddle"
								class="tell" value="${memberDto.tellMiddle }" /> - <input
								type="number" name="tellLast" id="tellLast" class="tell"
								value="${memberDto.tellLast }" /></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="email" id="user_email"
								value="${memberDto.email }"></td>
						</tr>
						<tr>
							<th>과목</th>
							<td><select name="search_subject" id="search_subject">
									<option value=null>전체</option>
									<c:if test="${memberDto.subject eq 'first' }">
										<option value="first" selected>1강의실: 프론트엔드 개발자 양성과정</option>
										<option value="second">2강의실: 백엔드 개발자 양성과정</option>
										<option value="third">3강의실: 풀스택 개발자 양성과정</option>
										<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
										<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
										<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
									</c:if>
									<c:if test="${memberDto.subject eq 'second' }">
										<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
										<option value="second" selected>2강의실: 백엔드 개발자 양성과정</option>
										<option value="third">3강의실: 풀스택 개발자 양성과정</option>
										<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
										<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
										<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
									</c:if>
									<c:if test="${memberDto.subject eq 'third' }">
										<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
										<option value="second">2강의실: 백엔드 개발자 양성과정</option>
										<option value="third" selected>3강의실: 풀스택 개발자 양성과정</option>
										<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
										<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
										<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
									</c:if>
									<c:if test="${memberDto.subject eq 'fourth' }">
										<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
										<option value="second">2강의실: 백엔드 개발자 양성과정</option>
										<option value="third">3강의실: 풀스택 개발자 양성과정</option>
										<option value="fourth" selected>4강의실: 퍼블리셔 양성과정</option>
										<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
										<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
									</c:if>
									<c:if test="${memberDto.subject eq 'fifth' }">
										<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
										<option value="second">2강의실: 백엔드 개발자 양성과정</option>
										<option value="third">3강의실: 풀스택 개발자 양성과정</option>
										<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
										<option value="fifth" selected>5강의실: 인공지능 개발자 양성과정</option>
										<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
									</c:if>
									<c:if test="${memberDto.subject eq 'sixth' }">
										<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
										<option value="second">2강의실: 백엔드 개발자 양성과정</option>
										<option value="third">3강의실: 풀스택 개발자 양성과정</option>
										<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
										<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
										<option value="sixth" selected>6강의실: 데이터 엔지니어 양성과정</option>
									</c:if>

							</select></td>
						</tr>
						<tr>
							<th>등록일</th>
							<fmt:parseDate value="${memberDto.regDate }" var="convertDate"
								pattern="yyyy-MM-dd HH:mm:ss" />
							<fmt:formatDate value="${convertDate }" var="regDate"
								pattern="yyyy-MM-dd" />
							<td><input type="date" name="regDate" id="regDate"
								value="${regDate}" /></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="btns">
				<button type="reset" class="btn">삭 제</button>
				<button type="submit" class="btn">확 인</button>
			</div>
		</form>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>