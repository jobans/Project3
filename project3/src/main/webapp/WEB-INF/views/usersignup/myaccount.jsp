<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 회원정보 수정 성공 확인하기 위해 alert 창 띄움  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
	var result = '${result}';
	
	if(result == 'Modisuccess'){
		alert('회원정보 수정이 정상처리되었습니다');
	}
	
	if(result == 'r_Modisuccess'){
		alert('리뷰 수정이 정상처리되었습니다');
	}
	
	if(result == 'b_Modisuccess'){
		alert('예약 수정이 정상처리되었습니다');
	}

	
</script>

 <title>4조 Spring Project</title>

	<!-- 관리자 테마 -->
	<link href="../resources/assets/libs/flot/css/float-chart.css" rel="stylesheet">
	<link href="../resources/dist/css/style.min.css" rel="stylesheet">

	<!-- main 테마 -->
	<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="../resources/css/modern-business.css" rel="stylesheet">

</head>
<body>
  <!-- Navigation -->
  <nav class="navbar fixed-top navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
      <a class="navbar-brand" href="../common/main">4조 Spring Project</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
      
        <ul class="navbar-nav ml-auto">
        
        <c:choose>
        	<c:when test="${!empty sessionScope.owner}">
        		<li class="nav-item dropdown">
        			<span class="nav-link">${sessionScope.owner.o_id } 님 환영합니다.</span>
        		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../common/logout">로그아웃</a>
          		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../ownersignup/myaccount">mypage</a>
          		</li>
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">공지사항</a>
          		</li>
        	</c:when>
        	
        	<c:when test="${!empty sessionScope.user}">
        		<li class="nav-item dropdown">
        			<span class="nav-link">${sessionScope.user.u_id } 님 환영합니다.</span>
        		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../common/logout">로그아웃</a>
          		</li>
        		<li class="nav-item">
            		<a class="nav-link" href="../usersignup/myaccount">mypage</a>
          		</li>
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">공지사항</a>
          		</li>
        	</c:when>
        
        	<c:otherwise>
        	
        		<!-- 회원가입으로 보내기 -->
	        	<li class="nav-item dropdown">
	            	<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownPortfolio" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	             	회원가입
	           		</a>
	            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="navbarDropdownPortfolio">
	              <a class="dropdown-item" href="../usersignup/register">일반 회원가입</a>
	              <a class="dropdown-item" href="../ownersignup/register">기업 회원가입</a>
	            </div>
          		</li>
          		
          		<!-- 로그인 -->
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">로그인</a>
          		</li>
          		
          		<!-- 공지사항 -->
          		<li class="nav-item">
            		<a class="nav-link" href="../common/login">공지사항</a>
          		</li>
        	</c:otherwise>

        
        </c:choose> 
        
        </ul>
      </div>
    </div>
  </nav>

	<div class="page-breadcrumb">
		<div align="center">
		    <h4>${uvo.u_id }님의  PAGE</h4>
		    <br />
		</div>
	</div>
	
	
<div class="container" align="center">
	
	<div class="row">
	<c:if test="${uvo.grade == 1}"> 
	
	<div class="col-md-12">
	<form id="form"  method="get">
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">ID</label>
	        <div class="col-sm-9">
		    	<input type="text" class="form-control " id ="u_id" name="u_id" value="${uvo.u_id }" readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">PW</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control"id="u_pw" name="u_pw" value="${uvo.u_pw }" readonly="readonly"  >
	        </div>
	    </div>
	     
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">이름</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_name" value="${uvo.u_name }" readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">휴대폰번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_phone" name="u_phone" value="${uvo.u_phone }" readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">E-MAIL</label>
	        <div class="col-sm-9">
	            <input type="email" class="form-control" name="u_email"  name="u_email" value="${uvo.u_email}" readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">생년월일</label>
	        <div class="col-sm-9">
	        
	            <input type="text" class="form-control" name="u_dob" value="<fmt:formatDate value="${uvo.u_dob  }" pattern="yyyy-MM-dd"/>"  readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">성별</label>
	        <div class="col-sm-9">
	            <c:if test="${uvo.u_sex == 1}">
				<input type="text" class="form-control"  name="u_sex" value="남성" readonly="readonly">
			</c:if>
			<c:if test="${uvo.u_sex == 2}">
				<input type="text" class="form-control"  name="u_sex" value="여성" readonly="readonly">
			</c:if>
	        </div>
	    </div>
	   
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">주소</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_add" value="${uvo.u_add }"  readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">등급</label>
	        <div class="col-sm-9">
	            <c:if test="${uvo.grade == 2}">
				<input type="text" class="form-control"  value="관리자" readonly="readonly">
			</c:if>
			<c:if test="${uvo.grade == 1}">
				<input type="text" class="form-control"  value="사용자" readonly="readonly">
			</c:if>
	        </div>
	    </div>
	    
	    <div align="center" >	
			<a href="../usersignup/modify"><button type="button" id="btn_mody" class="btn btn-warning btn-lg">수정하기</button></a>
      	</div>
	
		</form>
		
	<br />
	<br />
	</div>	

	

	<!-- 내 게시글 목록 -->
	
	<div class="col-md-6">

	<div class="card">
	    <div class="card-body">
	    	<h5 class="card-title m-b-0">내 게시글 목록</h5>
	    </div>
	        <table class="table">
	            <thead>
	                <tr>
	                    <th scope="col">업체명</th>
	                    <th scope="col">제목</th>
	                    <th scope="col">평점</th>
	                </tr>
	            </thead>
	            <tbody>
	            <c:forEach var="rvo"  items="${r_list }">
	                <tr>
	                    <td><a href="/common/r_site?bnum=${rvo.bnum }">${rvo.c_name }</a></td>
	                    <td>${rvo.r_name }</td>
	                    <td>${rvo.r_score }</td>
	                    <td>
							<a href="rev_modify?r_no=${rvo.r_no }"><button type="button" id="btn_r_modify">수정하기</button></a>	
						</td>
	                </tr>
	            </c:forEach>   
	            </tbody>
	        </table>
	    </div>
	</div>

	<div class="col-md-6">
		<div class="card">
	     <div class="card-body">
	         <h5 class="card-title m-b-0">예약 리스트</h5>
	     </div>
	        <table class="table">
	            <thead>
	                <tr>
		                <th scope="col">예약번호</th>
		                <th scope="col">업체명</th>
		                <th scope="col">예약날짜</th>
		                <th scope="col">인원수</th>
		                <th scope="col">확인</th>
		                <th scope="col">수정</th>
	                </tr>
	            </thead>
	            <tbody>
	            <c:forEach var="bvo"  items="${b_list }">
	                <tr>
	                    <td>${bvo.b_no }</td>
						<td>${bvo.c_name }</td>
						<td><fmt:formatDate value="${bvo.b_date }" pattern="yyyy-MM-dd"/></td>
						<td>${bvo.b_per }</td>	
						<td>${bvo.b_app }</td>	
	                    <td>
							<a href="rev_modify?r_no=${rvo.r_no }"><button type="button" id="btn_r_modify">수정하기</button></a>	
						</td>
	                </tr>
	            </c:forEach>   
	            </tbody>
	        </table>
	    </div>
    </div>
	</c:if>
    </div>	
    
	<c:if test="${uvo.grade == 2}">
	
		<h3>관리자 공지사항 리스트</h3>
		<div>
			<button type="submit" id="btn_a_n_write"><a href="a_n_write">글쓰기</a></button>			
		</div>
		
		<div>
			<table>
				<tr>
					<th>공지사항 번호</th>
					<th>제목</th>
					<th>내용</th>				
					<th>날짜</th>				
					<th>조회수</th>				
					<th>수정</th>				
					<th>삭제</th>
				</tr>
				
				<c:forEach var="avo" items="${ad_no_list }">
				<tr>
					<td>${avo.an_no }</td>
					<td>${avo.an_subject }</td>
					<td>${avo.an_contents }</td>
					<td>${avo.an_date }</td>
					<td>${avo.an_hits }</td>
					<td>
						<button type="submit" id="btn_a_n_mody"><a href="a_n_modify?an_no=${avo.an_no }">수정하기></a></button>
					</td>
				
					<td>
						<button type="submit" id="btn_a_n_delete"><a href="a_n_delete?an_no=${avo.an_no }">삭제></a></button>
					</td>
	
				</tr>
				</c:forEach>
			
			</table>	
		</div>
		
		
		
		<h3>사용자 리스트</h3>	
		<div>
			<table>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>주소</th>				
					<th>등록일</th>				
					<th>생년월일</th>				
					<th>성별</th>				
					<th>등급</th>				
					<th>이용정지</th>				
					<th>계정활성</th>				
					<th>삭제</th>				
	
				</tr>
				
				<c:forEach var="uvo"  items="${u_list }">
					<tr>
						<td>${uvo.u_id }</td>
						<td>${uvo.u_pw }</td>
						<td>${uvo.u_name }</td>
						<td>${uvo.u_phone }</td>
						<td>${uvo.u_email }</td>
						<td>${uvo.u_add }</td>
						<td>${uvo.u_date }</td>
						<td>${uvo.u_dob }</td>
						<td>${uvo.u_sex }</td>
						<td>${uvo.grade }</td>
						<td>
							<button type="submit" id="btn_u_stop"><a href="/usersignup/o_stop?u_id=${uvo.u_id }">이용정지</a></button>							
						</td>
						<td>
							<button type="submit" id="btn_u_stop"><a href="/usersignup/o_reactivated?u_id=${uvo.u_id }">계정활성</a></button>							
						</td>
						<td>
							<button type="submit" id="btn_u_delete"><a href="/usersignup/o_delete?u_id=${uvo.u_id }">삭제</a></button>							
						</td>			
					</tr>
				</c:forEach>
			</table>				
		</div>
		
		<br />
		
		<h3>사업자 리스트</h3>	
		<div>
			<table>
				<tr>
					<th>아이디</th>
					<th>비밀번호</th>
					<th>대표모범음식점번호</th>
					<th>이름</th>
					<th>전화번호</th>
					<th>이메일</th>
					<th>등록일</th>							
					<th>이용정지</th>				
					<th>계정활성</th>				
					<th>삭제</th>				
	
				</tr>
				
				<c:forEach var="ovo"  items="${o_list }">
					<tr>
						<td>${ovo.o_id }</td>
						<td>${ovo.o_pw }</td>
						<td>${ovo.bnum }</td>
						<td>${ovo.o_name }</td>
						<td>${ovo.o_phone }</td>
						<td>${ovo.o_email }</td>
						<td>${ovo.o_date }</td>
						<td>
							<button type="submit" id="btn_o_stop"><a href="/usersignup/o_stop?o_id=${ovo.o_id }">이용정지</a></button>							
						</td>
						<td>
							<button type="submit" id="btn_o_stop"><a href="/usersignup/o_reactivated?o_id=${ovo.o_id }">계정활성</a></button>							
						</td>
						<td>
							<button type="submit" id="btn_o_delete"><a href="/usersignup/o_delete?o_id=${ovo.o_id }">삭제</a></button>							
						</td>			
					</tr>
				</c:forEach>
			</table>				
		</div>
		
		<br />

		<h3>업체 리스트</h3>	
		<div>
			<table>
				<tr>
					<th>대표모범음식점번호</th>
					<th>사업자아이디</th>
					<th>업체명</th>
					<th>업체 평점</th>
					<th>조회수</th>
					<th>이용정지</th>				
					<th>삭제</th>				
	
				</tr>
				
				<c:forEach var="cvo"  items="${c_list }">
					<tr>
						<td>${cvo.bnum }</td>
						<td>${cvo.o_id }</td>
						<td>${cvo.c_name }</td>
						<td>${cvo.c_score }</td>
						<td>${cvo.c_hits }</td>
						<td>
							<button type="submit" id="btn_c_stop"><a href="/usersignup/c_stop?bnum=${cvo.bnum }">이용정지</a></button>							
						</td>
						<td>
							<button type="submit" id="btn_c_delete"><a href="/usersignup/c_delete?bnum=${cvo.bnum }">삭제</a></button>							
						</td>			
					</tr>
				</c:forEach>
			</table>				
		</div>

		
	
	</c:if>

	</div>

</div>
 										

<%@ include file="../footer2.jsp" %>