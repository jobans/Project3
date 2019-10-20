<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	var result = '${result}';
	
	if(result == 'rep_regsuccess'){
		alert('댓글 등록이 정상처리되었습니다');
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
<!-- 내용 -->
 <div class="page-breadcrumb">
	   
        <div align="center">
            <h4> ${rvo.u_id } 리뷰답글</h4>
            <br />
        </div>

	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->
		<form id="form" action="../usersignup/rep_write"  method="post">
	    <input type="hidden" id="bnum"  name="bnum" value="${bnum }"/>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">댓글번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="r_no" value="${rvo.r_no }" readonly="readonly" >
	        </div>
	    </div>
	    
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">내용</label>
	        <div class="col-sm-9">
	            <textarea  class="form-control"  name="re_r_contents" placeholder="댓글을 입력하세요" cols="35" rows="15" ></textarea>
	        </div>
	    </div>
	   
	    
	    <div align="center" style="margin-bottom: 150px;">	
			<!-- <a href="/ownersignup/register"><button type="button"  class="btn btn-outline-danger" >취소</button></a>
			&nbsp&nbsp&nbsp -->
			<a href="../ownersignup/register"><button type="submit" class="btn btn-warning btn-lg">작성</button></a> 
      	</div>
	
		</form>
	<%-- </div>					
		<div id="container">
			<div id="top">
				<p>
					<h3>${rvo.u_id } 님의 리뷰</h3>
				</p>
				
			</div>
			
			
			<div id="bnum">
				<p>업체명 : &nbsp; </p>
				<input type="text" name="bnum" id="bnum" value="${rvo.bnum }" />
			</div>
			
			<div id="r_name">
				<p>TITLE : &nbsp; </p>
				<input type="text" name="r_name" id="r_name" value="${rvo.r_name }"/>
			</div>
			
			<div id="r_contents">
				<p>
					<textarea name="r_contents" id="r_contents" cols="35" rows="10"  required>${rvo.r_contents }</textarea>
				</p>
			</div>
			
			<div id="r_score">
				<p>별점 : &nbsp; </p>
				<input type="text" name="r_score" id="r_score"  value="${rvo.r_score }" />
			</div>
			
			<br />
			
			<!-- 댓글 리스트 -->			
			<div>	
			<h3>업체 댓글</h3>		
			<c:forEach var="r_rvo"  items="${re_list }">
				<table class="table">                    
	                    <tr>
	                        <td>
	                            <textarea style="width: 1100px" rows="3" cols="30" id="comment" name="re_r_contents" placeholder="댓글을 입력하세요">${r_rvo.re_r_contents }</textarea>
	                        </td>
	                    </tr>
	                </table>
			</c:forEach>		
			</div>
			
			<br />
			
			<!-- 사업자 댓글 작성-->
			<c:if test="${owner != null}">
			  <div>
				<h3>업주 댓글 작성</h3>
				<form action="/usersignup/rep_write" method="post">
				 	<div>
		                <label >게시글 번호</label>
						<input type="text" class="form-control" name="r_no" value="${rvo.r_no }"  required>
		
		                <table class="table">                    
		                    <tr>
		                        <td>
		                            <textarea style="width: 1100px" rows="3" cols="30" id="comment" name="re_r_contents" placeholder="댓글을 입력하세요"></textarea>
		                            <br>
		                            	                     
		                            <div>
		                            	<button type="submit" id="btn_check" >등록</button>			 
		                            	
		                            </div>	                          	                            
		                        </td>
		                    </tr>
		                </table>
	            	</div>
	            </form>	
	          </div>
			</c:if>
			
		
		<br />
			
			<div >
				<button type="submit" id="btn_check" ><a href="/common/r_site?bnum=${rvo.bnum }">확인</a></button>
			</div>
		
		</div> --%>
	
	
	

<%@ include file="../footer2.jsp" %>