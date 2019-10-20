<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<%@ include file="../header.jsp" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

//아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
var emailck = 0;

$(document).ready(function(){ 

	
	// 비밀번호 유효성검사
	$("#o_pw").keyup(function(){ 
		var query = {o_pw : $("#o_pw").val()};
		
		$.ajax({
			url : "/ownersignup/pwCheck",
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
		if($("#o_pw").val()!=$('#repw').val()){ 
			$("#pw_check2").text("패스워드가 불일치 합니다");
		    $("#pw_check2").attr("style", "color:#f00");    

		}else{ 
			$("#pw_check2").text("패스워드가 일치 합니다"); 
			$("#pw_check2").attr("style", "color:#00f");
			
		} 
	}); 


	//email 유효성검사
	$("#o_email").keyup(function(){ 
		var query = {o_email : $("#o_email").val()};

		$.ajax({
			url : "/ownersignup/emailcheck",
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
		var query = {o_email : $("#o_email").val()};
		
		$.ajax({
			url : "/ownersignup/emailducheck",
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
		if(confirm("회원정보를 수정 하시겠습니까?")){
	        
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
	<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">개인정보 수정</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->
	<form id="form"  method="post">
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">ID</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " value="${ownerVO.o_id }" id="o_id" name="o_id" readonly="readonly">
	        </div>
	    </div>
		<div class="form-group row" style="width: 50%;">
			<label class="col-sm-3 text-left control-label col-form-label">대표모범음식점번호</label>
		    <div class="col-sm-9">
		    	<input type="text" class="form-control " id="bnum" value="${ownerVO.bnum }" readonly="readonly">
		    </div>
		</div>
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">PW</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control" placeholder="비밀번호를 입력하세요" id="o_pw" name="o_pw" >
	            <div class="check_font" id="pw_check1" style="color:blue"> 비밀번호 : 문자+숫자+특수문자 포함 6~18 자 사이  </div>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">PW확인</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control" placeholder="비밀번호를 확인하세요" id="repw" name="repw" >
	            <div class="check_font" id="pw_check2" style="color:blue"> 동일한 비밀번호 입력 </div>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">이름</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="o_name" id="o_name" value="${ownerVO.o_name }" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">전화번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" name="o_phone" id="o_phone" value="${ownerVO.o_phone }" >
	        </div>
	    </div>
	      <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">메일</label>
	        <div class="col-sm-9">
	            <input type="email" class="form-control" name="o_email" id="o_email" value="${ownerVO.o_email}" >
	           
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">등록일</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control"  value="<fmt:formatDate value="${ownerVO.o_date}" pattern="yyyy-MM-dd"/>" readonly="readonly">
	        </div>
	    </div>
	  	
	    
	
	</div>	
											
	<div align="center">	
		
		<a href="../ownersignup/myaccount"><button type="button"  class="btn btn-danger btn-lg" >취소</button></a>
		&nbsp&nbsp&nbsp
		<a href="../ownersignup/modify"><button type="submit" class="btn btn-warning btn-lg">저장</button></a> 
      
	</div>
	</form>
	
<%@ include file="../footer.jsp" %>   