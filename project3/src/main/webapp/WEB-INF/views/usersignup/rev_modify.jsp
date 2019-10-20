<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>    
<html>
<head>
<meta charset="UTF-8">

<title>4조 Spring Project</title>
 
    <!-- 관리자 테마 -->
    <link href="../resources/assets/libs/flot/css/float-chart.css" rel="stylesheet">
    <link href="../resources/dist/css/style.min.css" rel="stylesheet">

  	<!-- main 테마 -->
  	<link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  	<link href="../resources/css/modern-business.css" rel="stylesheet">

</head>
<body>
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
            <h4> ${c_name } 리뷰수정</h4>
            <br />
        </div>

	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->
		<form id="form" action="../usersignup/rev_modify"  method="post">
	    <input type="hidden" id="bnum"  name="bnum" value="${rvo.bnum }"/>
	    <input type="hidden" name="r_no" id="r_no" value="${rvo.r_no }"/>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">작성자</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_id" id="u_id" value="${rvo.u_id }" readonly="readonly" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">제목</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="r_name" id="r_name" value="${rvo.r_name }">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">내용</label>
	        <div class="col-sm-9">
	            <textarea  class="form-control"  name="r_contents" id="r_contents" cols="35" rows="15" >${rvo.r_contents }</textarea>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">별점</label>
	        <div class="col-sm-9" >
	            <div class="custom-control custom-radio">
                    <input type="radio" name="r_score" id="r_score" value="1">1
					<input type="radio" name="r_score" id="r_score" value="2">2
					<input type="radio" name="r_score" id="r_score" value="3">3
					<input type="radio" name="r_score" id="r_score" value="4">4
					<input type="radio" name="r_score" id="r_score" value="5">5
                </div>
	        </div>
	    </div>
	    
	    <div align="center" style="margin-bottom: 150px;">	
			<!-- <a href="/ownersignup/register"><button type="button"  class="btn btn-outline-danger" >취소</button></a>
			&nbsp&nbsp&nbsp -->
			<button type="submit" class="btn btn-warning btn-lg">수정하기</button>
      	</div>
	
		</form>
	</div>


<%@ include file="../footer2.jsp" %>