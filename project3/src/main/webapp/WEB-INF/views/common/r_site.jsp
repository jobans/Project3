<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(function sh(){
	$("#btn_search").click(function(){
		console.log("click");
		self.location = "search" +"?keyword="+$("#keyword").val();
		});		
	});	

</script>
<title>4조 Spring Project</title>

   <!-- 관리자 테마 -->
    <link href="../resources/assets/libs/flot/css/float-chart.css" rel="stylesheet">
    <link href="../resources/dist/css/style.min.css" rel="stylesheet">

  	<!-- main 테마 -->
  	<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<link href="../resources/css/modern-business.css" rel="stylesheet">

</head>
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
<div class="container">

    <!-- Page Heading/Breadcrumbs -->
    <h1 class="mt-4 mb-3">${cdbvo.c_name }
      <small> <span> ┃ 평점 : </span>${cvo.c_score } ┃ 리뷰(${countreview }) ┃ 조회수  :  ${cvo.c_hits }</small>
    </h1>

    <div class="row">

      <!-- Post Content Column -->
      <div class="col-lg-8">

        <!-- Preview Image -->
        <img class="img-fluid rounded" src="${cvo.c_photo }" alt="" style="width: 900px; height: 300px; ">

        <hr>
		<div class="card">
            <table class="table">
                <tbody>
                    <tr>
                   		<th scope="col" >주소</th>
                        <td>${cdbvo.c_add }</td>
                    </tr>
                    <tr>
                   		<th scope="col">전화번호</th>
                        <td>${cdbvo.c_phone }</td>
                    </tr>
                    <tr>
                   		<th scope="col">메뉴</th>
                        <td>${cvo.c_menu }</td>
                    </tr>
                    <tr>
                   		<th scope="col">가격대</th>
                        <td>${cvo.c_price }</td>
                    </tr>
                    <tr>
                   		<th scope="col">주차</th>
                        <td>${cvo.c_parking }</td>
                    </tr>
                    <tr>
                   		<th scope="col">영업시간</th>
                        <td>${cvo.c_time }</td>
                    </tr>
                    <tr>
                   		<th scope="col">라스트오더</th>
                        <td>${cvo.c_last }</td>
                    </tr>
                </tbody>
            </table>
        </div>

        <hr>

        <!-- Comments Form -->
       	<c:choose>
       	<c:when test="${!empty sessionScope.user}">
	        <div style="margin-bottom: 50px; " align="center">
			     <a href="/usersignup/rev_write"> <button type="submit" id="btn_revwrite" class="btn btn-success" >리뷰쓰기</button></a>
			     <a href="/common/booking?bnum=${bnum }"> <button type="button" id="btn_revwrite" class="btn btn-success" >예약하기</button></a>
	        </div>
        </c:when>
		</c:choose>  
      
		<c:forEach var="rvo" items="${rlist }">
		<c:if test="${rvo.bnum == bnum }">
        <!-- Comment with nested comments -->
        <div class="media mb-4">
          <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
          <div class="media-body">
          	${rvo.u_id } 님의 : ${rvo.r_name } ┃ 평점  : ${rvo.r_score } ┃ 작성일 : <fmt:formatDate value="${rvo.r_date }" pattern="yyyy-MM-dd"/> 
          	<c:choose>
          		<c:when test="${sessionScope.user.u_id == rvo.u_id }">
          			<input type="hidden" name="r_no" value="${rvo.r_no }" />
          		</c:when>
          		<c:when test="${!empty sessionScope.owner}">
          			<a href="/usersignup/rev_select?r_no=${rvo.r_no }"><input type="button" class="btn btn-warning" value="답글달기"  /></a>
          		</c:when>
          	</c:choose>        
          	<!-- <h5 class="mt-0">Commenter Name</h5> -->
            <p>
            ${rvo.r_contents }
            </p>
			
			<c:if test="${sessionScope.user.u_id == rvo.u_id }">
	   			<a href="../usersignup/rev_modify?r_no=${rvo.r_no }"><input type="button" value="수정하기" class="btn btn-warning" /></a>
	   			<a href="../usersignup/rev_delete?r_no=${rvo.r_no }"><input type="button" value="삭제하기" class="btn btn-danger" /></a>	
			</c:if>
            
			<c:forEach var="r" items="${r }">
			<c:if test="${rvo.r_no == r.r_no }">
            <div class="media mt-4">
              <img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
              <div class="media-body">
              	${r.o_id } 님의  답글 ┃ 작성일 :  <fmt:formatDate value="${r.regdate }" pattern="yyyy-MM-dd"/> 
	          	<%-- <c:choose>
	          		<c:when test="${sessionScope.owner.o_id == rvo.o_id }">
	          			<input type="button" value="수정하기" />
	          		</c:when>
	          		
	          	</c:choose>     --%>    
	          	<!-- <h5 class="mt-0">Commenter Name</h5> -->
	            <p>
	            ${r.re_r_contents }
	            </p>
            
              </div>
            </div>
            </c:if>
            </c:forEach>
			
            
          </div>
        </div>
        </c:if>
		</c:forEach>

      </div>
      <!-- Sidebar Widgets Column -->
      <div class="col-md-4">

        <!-- Search Widget -->
        <div class="card mb-4">
          <h5 class="card-header">검색하기</h5>
          <div class="card-body">
            <div class="input-group">
              <input type="text" class="form-control" placeholder="맛집을 찾아보세요" id="keyword">
              <span class="input-group-btn">
                <button class="btn btn-secondary" id="btn_search" name="#btn_search" onclick="sh()">찾기</button>
              </span>
            </div>
          </div>
        </div>

          
       

      </div>

    </div>
    <!-- /.row -->
	 </div>
	
	

<%@ include file="../footer2.jsp" %>