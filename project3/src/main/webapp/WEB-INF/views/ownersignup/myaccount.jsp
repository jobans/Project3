<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">


	var result = '${result}';
	
	if(result == 'Modisuccess'){
		alert('회원정보 수정이 정상처리되었습니다');
	}
	
	if(result == 'Reqfail'){
		alert('업체등록 요청이 거부되었습니다. 모범음식점 번호를 확인하세요');
	}
	
	if(result == 'Delcomsuccess'){
		alert('업체가 삭제 되었습니다');
	}
	if(result == 'Regsuccess'){
		alert('업체가 등록 되었습니다');
	}
$(document).ready(function(){ 	
	
	
	$("#btn_delcom").click(function(){
		 Confirm(cname + " 업체를  삭제하시겠습니까", "#RED", function(result){
	            if(result == true) {
	                location.href = '../comreg/deletecom';
	            } else if(result == false) {
	               
	            }
	      });
	});
});
	
</script>

	<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">개인정보</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->

	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">ID</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " value="${ovo.o_id}" readonly="readonly">
	        </div>
	    </div>
		<div class="form-group row" style="width: 50%;">
			<label class="col-sm-3 text-left control-label col-form-label">대표모범음식점번호</label>
		    <div class="col-sm-9">
		    	<input type="text" class="form-control " value="${ovo.bnum }" readonly="readonly">
		    </div>
		</div>
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">PW</label>
	        <div class="col-sm-9">
	            <input type="password" class="form-control" value="${ovo.o_pw }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">이름</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" value="${ovo.o_name }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">전화번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" value="${ovo.o_phone }" readonly="readonly">
	        </div>
	    </div>
	      <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">메일</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" value="${ovo.o_email }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">	
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">등록일</label>
	        <div class="col-sm-9">
	       
	            <input type="text" class="form-control" value=" <fmt:formatDate value="${ovo.o_date }" pattern="yyyy-MM-dd"/>" readonly="readonly">
	        </div>
	    </div>
	    
	    <div align="center">
	    	<br />
	    	<br /><br />
	    	<a href="../ownersignup/modify"><button type="button" class="btn btn-warning">수정하기</button></a>
	    </div>
	
	</div>	
<%@ include file="../footer.jsp" %>   