<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">

//아이디 체크여부 확인 (아이디 중복일 경우 = 0 , 중복이 아닐경우 = 1 )
var emailck = 0;

$(document).ready(function(){ 

	
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
	
<title>modify.jsp</title>
</head>
<body>
	
	<h3> 사용자 개인정보 수정 PAGE</h3>
	<form id="form" action="/usersignup/modify" method="post">
	<!-- 아이디 -->
		<div class="form-group">
			<label for="u_id">아이디</label>
				<input type="text" class="form-control" id ="u_id" name="u_id" value="${uvo.u_id }" required>
		</div>
		
		<!-- 비밀번호 -->
		<div class="form-group">
			<label for="u_pw">비밀번호</label>
				<input type="password" class="form-control"  id="u_pw" name="u_pw" placeholder="PASSWORD" required>
				<div class="check_font" id="pw_check1" style="color:blue"> 비밀번호 : 문자+숫자+특수문자 포함 6~18 자 사이  </div>
		</div>
		
		<!-- 비밀번호 재확인 -->
		<div class="form-group">
			<label for="u_pw2">비밀번호 확인</label>
				<input type="password" class="form-control" id="repw" placeholder="Confirm Password" required>
			<br />
			<div class="check_font" id="pw_check2" style="color:blue"> 동일한 비밀번호 입력 </div>
			<br />
			
		</div>
		
		<!-- 이름 -->
		<div class="form-group">
			<label for="u_name">이름</label>
				<input type="text" class="form-control"  name="u_name" value="${uvo.u_name }"  required>
		</div>
		
		<!-- 휴대전화 -->
		<div class="form-group">
			<label for="u_phone">휴대전화 ('-' 없이 번호만 입력해주세요)</label>
			<input type="text" class="form-control"  name="u_phone" value="${uvo.u_phone }" required>
		</div>
		
		<!-- 본인확인 이메일 -->
		<div class="form-group">
			<label for="u_email">이메일</label>
				<input type="text" id= "u_email" class="form-control" name="u_email" value="${uvo.u_email}" required>
				<div class="check_font" id="emailcheck" style="color:blue"> 이메일 형식을 확인하세요 </div>			
		</div>
		<div>
			<button type="button" id="btn_checkemail">email 중복 확인</button>
			<p>
			  <span id="emailducheck">email을 확인하세요</span>
			</p>
		</div>
		
		<!-- 주소 -->
		<div class="form-group">
			<label for="u_add">주소</label>
				<input type="text" class="form-control"  name="u_add" value="${uvo.u_add }"  required>
		</div>
		
		<!-- 생년월일 -->
		<div class="form-group">
			<label for="u_dob">생년월일</label>
				<input type="text" class="form-control"  name="u_dob" value="${uvo.u_dob }" disabled="disabled" required>
		</div>
		
		<!-- 성별 -->
		<div class="form-group">
			<label for="u_sex">성별</label>
				<input type="text" class="form-control"  name="u_sex" value="${uvo.u_sex }" disabled="disabled" required>
		</div>
		
		<!-- 등록일 -->
		<div class="form-group">
			<label >등록일</label>
			<input type="text" class="form-control"  value="${uvo.u_date}" disabled="disabled" required>
		</div>
		
		
		<div>
			
			<button type="reset" id="btn_reset">RESET</button>
			<button type="submit" id="btn_register">수정하기</button>			 
       
		</div>
										
	</form>
									

</body>
</html>