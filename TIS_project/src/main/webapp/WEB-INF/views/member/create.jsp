<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main id="main">
	<div class="contents">
		<div class="title">
			<h1>
				<a href="List.do">원생 관리</a><span class="depth"> > 신규 등록</span>
			</h1>
		</div>
		<form action="../member/CreateProcess.do" method="POST" class="form">
			<div class="inner">
				<div class="info">
					<table>
						<colgroup>
							<col style="width: 20%" />
							<col style="width: 80%" />
						</colgroup>
						<tr>
							<th>이름</th>
							<td><input type="text" name="name" id="name" /></td>
						</tr>
						<tr>
							<th>분류</th>
							<td><select name="position" id="position">
									<option value=null>전체</option>
									<option value="S">원생</option>
									<option value="T">강사</option>
									<option value="F">직원</option>
							</select></td>
						</tr>
						<tr>
							<th>아이디</th>
							<td><input type="text" name="id" id="user_id"
								placeholder="아이디를 입력하세요." style="width: calc(100% - 120px)">
								<button class="btn btnIdCheck sticker" id="btnIdCheck">ID중복체크</button></td>
						</tr>
						<tr>
							<th>패스워드</th>
							<td><input type="password" name="password" id="user_pw"
								placeholder="비밀번호를 입력하세요."></td>
						</tr>
						<tr>
							<th>전화번호</th>
							<td><select name="tellFirst" class="short tell">
									<option value="010" selected>010</option>
									<option value="011">011</option>
									<option value="02">02</option>
							</select> - <input type="number" name="tellMiddle" id="tellMiddle"
								class="tell" /> - <input type="number" name="tellLast"
								id="tellLast" class="tell" /></td>
						</tr>
						<tr>
							<th>이메일</th>
							<td><input type="text" name="email" id="user_email"
								placeholder="메일을 입력하세요."></td>
						</tr>
						<tr>
							<th>과목</th>
							<td><select name="search_subject" id="search_subject">
									<option value=null>전체</option>
									<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
									<option value="second">2강의실: 백엔드 개발자 양성과정</option>
									<option value="third">3강의실: 풀스택 개발자 양성과정</option>
									<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
									<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
									<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
							</select></td>
						</tr>
						<tr>
							<th>등록일</th>
							<td><input type="date" name="regDate" id="regDate" /></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="btns">
				<a href="List.do" class="btn">뒤로 가기</a>
				<button type="submit" class="btn submit">신규 등록</button>
			</div>
		</form>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>