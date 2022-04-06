<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main id="main">
	<div class="contents">
		<div class="title">
			<h1><a href="Management.do">원생 관리</a></h1>
		</div>
		<div class="inner">
			<div class="searchBox">
				<form action="../member/SearchProcess.do" method="post">
					<label class="positionBox"> <span>분류</span> <select
						name="position" id="position">
							<option value="all">전체</option>
							<option value="student">원생</option>
							<option value="teacher">강사</option>
							<option value="staff">직원</option>
					</select>
					</label> 
					<label class="subjectBox"> <span>과목</span> <select
						name="subject" id="subject">
							<option value="all">전체</option>
							<option value="first">1강의실: 프론트엔드 개발자 양성과정</option>
							<option value="second">2강의실: 백엔드 개발자 양성과정</option>
							<option value="third">3강의실: 풀스택 개발자 양성과정</option>
							<option value="fourth">4강의실: 퍼블리셔 양성과정</option>
							<option value="fifth">5강의실: 인공지능 개발자 양성과정</option>
							<option value="sixth">6강의실: 데이터 엔지니어 양성과정</option>
					</select>
					</label> 
					<label class="nameBox"> <span>이름</span> <input type="text"
						name="name" id="name" />
					</label>
					<button class="btn" type="submit">
						<span class="material-icons"> search </span>
					</button>
				</form>
			</div>
			<div class="viewer">
				<table>
					<colgroup>
						<col style="width: 2.5%" />
						<col style="width: 3.5%" />
						<col style="width: 8%" />
						<col style="width: 12%" />
						<col style="width: 30%" />
						<col style="width: 15%" />
						<col style="width: 20%" />
						<col style="width: 9%" />
					</colgroup>
					<thead>
						<tr>
							<th><input type="checkbox" name="allSelected"
								id="allSelected" /></th>
							<th>순서</th>
							<th>이름</th>
							<th>아이디</th>
							<th>과목</th>
							<th>전화번호</th>
							<th>이메일</th>
							<th>등록일</th>
						</tr>
					</thead>
					<tbody>
						
					</tbody>
				</table>
			</div>
		</div>
		<div class="btns">
			<a href="" class="btn delete">삭 제</a> <a href="studentCreate.html"
				class="btn create">신규 등록</a>
		</div>
	</div>
	<!-- <div class="sidebar">
		<ul>
			<li class="on"><a href="Management.do">원생 관리</a></li>
			<li><a href="">경영 관리</a></li>
		</ul>
	</div> -->
</main>
<%@ include file="../include/footer.jsp"%>