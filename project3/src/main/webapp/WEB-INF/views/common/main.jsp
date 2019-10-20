<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 로그아웃 성공 확인하기 위해 alert 창 띄움  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

	var result = '${result}';
	
	if(result == 'LoginSeccess'){
		alert('로그인 되었습니다');
	};
	
	if(result == 'Logoutsuccess'){
		alert('로그아웃 정상처리되었습니다');
	};
	
	if(result == 'Delsuccess'){
		alert('회원탈퇴 되었습니다');
	};
	
	if(result == 'Inputsuccess'){	
		alert('가입을 축하합니다');
	};
	/* }
	if(session.getAttribute("user") != null){
		String id = user.u_id
		
	} else if(session.getAttribute("owner") != null){
		String id = owner.o_id
	}
	 */
/* 검색기능 */
$(function sh(){
	$("#btn_search").click(function(){
		console.log("click");
		self.location = "search" +"?keyword="+$("#keyword").val();
		});		
	});	
		
 </script>
 <title>4조 Spring Project</title>

  <!-- Bootstrap core CSS -->
  <link href="../resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
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


  
  <div class="container">
  <!-- Page Content -->
  <div class="card-body" style="margin-bottom: 200px; margin-top: 200px; " >
            <div class="input-group" align="center">
              <input type="text" class="form-control" placeholder="맛집을 찾아보세요" id="keyword">
              <span class="input-group-btn">
                <button class="btn btn-secondary" type="button" id="btn_search" name="#btn_search" onclick="sh()">찾기</button>
              </span>
            </div>
          </div>
    <!-- Portfolio Section -->
    <h2>BEST 맛집</h2>
	
	
    <div class="row">
	<c:forEach begin="0" end="5" var="com" items="${top_list }">
      <div class="col-lg-4 col-sm-6 portfolio-item">
        <div class="card h-100">
          <c:if test="${ com.c_photo == null }">
          <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
          </c:if>
          <c:if test="${ com.c_photo != null }">
          <a href="#"><img class="card-img-top " src="${ com.c_photo }" style="width: 348px; height: 200px;" alt=""></a>
           </c:if>
          <div class="card-body">
            <h4 class="card-title">
              <p><a href="../common/r_site?bnum=${com.bnum }">${com.c_name }</a></p>
              
               <span>평점 : </span>${com.c_score }
            </h4>
            <%-- <p class="card-text">${com.c_contents }</p> --%>
          </div>
        </div>
      </div>
      
     </c:forEach>
      </div>
      </div>

    <!-- /.row -->

<%@ include file="../footer2.jsp" %>