<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>

var idck = 0;
var emailck = 0;

$(document).ready(function(){ 
	

	//아이디 중복확인 
	$("#btn_checkid").click(function(){
		
		var query = {u_id : $("#u_id").val()};
		
		$.ajax({
			url : "/usersignup/idcheck",
			type : "post",
			data : query,
			success : function(data){
				
				if(data == 0) {
				    $("#id_check").text("아이디 사용 불가");
				    $("#id_check").attr("style", "color:#f00"); 
			   } else {
				    $("#id_check").text("아이디 사용 가능");
				    $("#id_check").attr("style", "color:#00f");		    
				    $("#btn_register").removeAttr("disabled");
				    
				   idck = 1;
				   
				   console.log("data : " + data);
				   console.log("idck : " + idck);
			   }	
		  }
	
		});
	});
	
	// 확인된 아이디 수정 입력시 keyup 함수
	$("#u_id").keyup(function(){
		 $("#id_check").text("아이디 중복확인 해주십시오.");
		 $("#id_check").attr("style", "color:#f00");	 
		 $("#btn_register").attr("disabled", "disabled");
		 
	}); 

	// 비밀번호 유효성검사
	$("#u_pw").keyup(function(){ 
		var query = {u_pw : $("#u_pw").val()};
		
		$.ajax({
			url : "/usersignup/pwCheck",
			type : "post",
			data : query,
			success : function(data){
				
				console.log("pwdata : " + data);
				
				if(data == false) {
				    $("#pw_check1").text("사용 불가");
				    $("#pw_check1").attr("style", "color:#f00");    
			   } else{
				    $("#pw_check1").text("사용 가능");
				    $("#pw_check1").attr("style", "color:#00f");
			   }	
		  }

		});
			
	}); 
	
	// 비밀번호 일치여부
	$("#repw").keyup(function(){ 
		if($("#u_pw").val()!=$('#repw').val()){ 
			$("#pw_check2").text("패스워드가 불일치 합니다");
		    $("#pw_check2").attr("style", "color:#f00");    

		}else{ 
			$("#pw_check2").text("패스워드가 일치 합니다"); 
			$("#pw_check2").attr("style", "color:#00f");
			
		} 
	}); 


	//email 유효성검사
	$("#u_email").keyup(function(){ 
		var query = {u_email : $("#u_email").val()};
		
		$.ajax({
			url : "/usersignup/emailcheck",
			type : "post",
			data : query,
			success : function(data){
				
				console.log("emaildata : " + data);
				
				if(data == false) {
				    $("#emailcheck").text("이메일 사용 불가");
				    $("#emailcheck").attr("style", "color:#f00");    
			   } else{
				    $("#emailcheck").text("이메일 사용 가능");
				    $("#emailcheck").attr("style", "color:#00f");
			   }	
		  }
	
		});
			
	}); 

	// 이메일 중복확인
	$("#btn_checkemail").click(function(){
		var query = {u_email : $("#u_email").val()};
		
		$.ajax({
			url : "/usersignup/emailducheck",
			type : "post",
			data : query,
			success : function(data){
				
				console.log("emaildudata : " + data);
				
				if(data == 0) {
				    $("#emailducheck").text("사용 불가");
				    $("#emailducheck").attr("style", "color:#f00");    
			   } else {
				    $("#emailducheck").text("사용 가능");
				    $("#emailducheck").attr("style", "color:#00f");
				    
				    emailck = 1;
			   }	
		  }
	
		});
	});
	
	$("btn_register").click(function(){
		if(confirm("회원가입을 하시겠습니까?")){
	        if(idck==0){
	            alert('아이디 중복체크를 해주세요');
	            return false;
	        }else{
	        	$("#form").submit();
	        }
	        
	        if(emailck==0){
	            alert('이메일 중복체크를 해주세요');
	            return false;
	        }else{
	        	$("#form").submit();
	        }
	    }
	});

	
}); 
 
	// 알림창
	var result = '${result}';
	
	if(result == 'Inputsuccess'){
		alert('입력된 이메일로 인증키를 발송하였습니다. 메일을 확인하시고, "인증하기"를 눌러주시면 회원가입이 완료됩니다');
	}

	
</script>
<script src="https://ssl.daumcdn.net/dmaps/map_js_init/postcode.v2.js"></script>
<script>
	function add(){
	    new daum.Postcode({
	        oncomplete: function(data) {
	        	var newadd = data.roadAddress;
	        	document.getElementById('u_add').value = newadd;
	        }
	    }).open();
		
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

 <!-- 내용 -->
 <div class="page-breadcrumb">
	<div align="center">
	    <h4>일반 회원가입</h4>
	    <br />
	</div>
</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->
		<form id="form" action="/usersignup/register"  method="post">
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">ID</label>
	        <div class="col-sm-9">
		    	<input type="text" class="form-control " id ="u_id" name="u_id" placeholder="ID를 입력하세요"  >
		        <p><span id="id_check" style="color:blue" >아이디를 입력하세요</span></p> 
		      	<button type="button"  id="btn_checkid" class="btn btn-outline-success" >아이디 중복 확인</button>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">PW</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control"id="u_pw" name="u_pw"placeholder="비빌번호를 입력하세요"  >
	            <div class="check_font" id="pw_check1" style="color:blue"> 비밀번호 : 문자+숫자+특수문자 포함 6~18 자 사이  </div>
	        </div>
	    </div>
	     <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">PW 확인</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control" id="repw" name="repw"  placeholder="비빌번호를 확인하세요"  >
	            <div class="check_font" id="pw_check2" style="color:blue"> 동일한 비밀번호 입력 </div>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">이름</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_name" placeholder="이름을 입력하세요" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">휴대폰번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_phone" placeholder="01055557777" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">E-MAIL</label>
	        <div class="col-sm-9">
	            <input type="email" class="form-control" name="u_email" id="u_email"  placeholder="E-mail"  >
	         
				<p><span id="emailducheck" style="color:blue">email 중복확인을 해주세요</span></p>
	            <button type="button" id="btn_checkemail" class="btn btn-outline-success">email 중복 확인</button>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">생년월일</label>
	        <div class="col-sm-9">
	            <input type="date" class="form-control" name="u_dob" placeholder="" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">성별</label>
	        <div class="col-sm-9" >
	            <div class="custom-control custom-radio">
                    <input type="radio" id="u_sex" name="u_sex" value="1">남자
                    <input type="radio" id="u_sex" name="u_sex" value="2">여자
                </div>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">주소</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="u_add" id="u_add" placeholder="주소를 입력하세요" >
	            <br />
	        	<button type="button"  onclick="add()" class="btn btn-outline-success" >주소찾기</button>
	        </div>
	    </div>
	    <div align="center" style="margin-bottom: 150px;">	
			<!-- <a href="/ownersignup/register"><button type="button"  class="btn btn-outline-danger" >취소</button></a>
			&nbsp&nbsp&nbsp -->
			<a href="../ownersignup/register"><button type="submit" class="btn btn-warning btn-lg">가입하기</button></a> 
      	</div>
	
		</form>
	</div>					
	

<%@ include file="../footer2.jsp" %>