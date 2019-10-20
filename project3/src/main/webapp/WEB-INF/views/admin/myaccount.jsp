<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ad_account.jsp</title>
</head>
<body>
	<h3>사용자 계정 보기</h3>
	<div>
		<div class="form-group">
			<label for="user_id">아이디</label>
				<input type="text" class="form-control" id ="u_id" name="u_id" value="${uvo.u_id }" disabled="disabled" required>
		</div>
		
		<!-- 비밀번호 -->
		<div class="form-group">
			<label for="u_pw">비밀번호</label>
				<input type="password" class="form-control"  id="u_pw" name="u_pw" value="${uvo.u_id }" disabled="disabled" required>
		</div>
		
		<!-- 이름 -->
		<div class="form-group">
			<label for="u_name">이름</label>
				<input type="text" class="form-control"  name="u_name" value="${uvo.u_name }" disabled="disabled" required>
		</div>
		
		<!-- 휴대전화 -->
		<div class="form-group">
			<label for="u_phone">휴대전화</label>
			<input type="text" class="form-control"  name="u_phone" value="${uvo.u_phone }" disabled="disabled" required>
		</div>
		
		<!-- 본인확인 이메일 -->
		<div class="form-group">
			<label for="u_email">이메일</label>
				<input type="text" id= "u_email" class="form-control" name="u_email" value="${uvo.u_email}" disabled="disabled" required>
		</div>
		
		
		<!-- 주소 -->
		<div class="form-group">
			<label for="u_add">주소</label>
				<input type="text" class="form-control"  name="u_add" value="${uvo.u_add }" disabled="disabled" required>
		</div>
		
		<!-- 생년월일 -->
		<div class="form-group">
			<label for="u_dob">생년월일</label>
				<input type="text" class="form-control"  name="u_dob" value="${uvo.u_dob }" disabled="disabled" required>
		</div>
		
		<!-- 성별 -->
		<div class="form-group">
			<label for="u_sex">성별</label>
			
			<c:if test="${uvo.u_sex == 1}">
				<input type="text" class="form-control"  name="u_sex" value="남성" disabled="disabled" required>
			</c:if>
			<c:if test="${uvo.u_sex == 2}">
				<input type="text" class="form-control"  name="u_sex" value="여성" disabled="disabled" required>
			</c:if>
		</div>
		
		<!-- 등록일 -->
		<div class="form-group">
			<label >등록일</label>
			<input type="text" class="form-control"  value="${uvo.u_date}" disabled="disabled" required>
		</div>
		
		<!-- 등급 -->
		<div class="form-group">
			<label >등급</label>
			<c:if test="${uvo.grade == 1}">
				<input type="text" class="form-control"  value="관리자" disabled="disabled" required>
			</c:if>
			<c:if test="${uvo.grade == 2}">
				<input type="text" class="form-control"  value="일반인" disabled="disabled" required>
			</c:if>
		</div>
		
		<br />
		
		<div>
		
			<button type="submit" id="btn_mody"><a href="modify">수정하기</a></button>
         	<button type="reset" id="btn_main"><a href="/common/main">main으로</a></button>
		
		</div>
	</div>	
	
	<!-- 내 게시글 목록 -->
	<h3>내 게시글 목록</h3>
	
	<div>
		<table>
			<tr>
				<th>업체번호</th>
				<th>업체명</th>
				<th>제목</th>
				<th>내용</th>
				<th>평점</th>
				<th>작성일</th>				
				<th>수정하기</th>				

			</tr>
			
			<c:forEach var="rvo"  items="${r_list }">
			<tr>
				<td>${rvo.bnum }</td>
				<td>${rvo.c_name }</td>
				<td>${rvo.r_name }</td>
				<td>${rvo.r_contents }</td>
				<td>${rvo.r_score }</td>
				<td>${rvo.r_date }</td>
				<td>
					<button type="submit" id="btn_r_modify"><a href="/usersignup/rev_modify?r_no=${rvo.r_no }">수정하기</a></button>
				</td>
		
			</tr>
			</c:forEach>
		</table>		
	
	</div>
	
	<!-- 나의 예약사항 보기-->
	<h3>예약 리스트</h3>
	<div>
		<table>
			<tr>
				<th>예약번호</th>
				<th>업체명</th>
				<th>예약날짜</th>
				<th>인원수</th>		
				<th>수정</th>		
			</tr>
			
			<c:forEach var="bvo"  items="${b_list }">
			<tr>
				<td>${bvo.b_no }</td>
				<td>${bvo.c_name }</td>
				<td>${bvo.b_date }</td>
				<td>${bvo.b_per }</td>				
				<td></td>				
				<td>
					<button type="submit" id="btn_b_modify"><a href="/usersignup/b_modify?b_no=${bvo.b_no }">수정하기</a></button>
				</td>
		
			</tr>
			</c:forEach>
		</table>		
	
	</div>
	
</body>
</html>