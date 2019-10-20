<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ include file="../header.jsp" %>

<script type="text/javascript">

var result = '${result}';

	if(result == 'Reqfail'){
		alert('모범음식점 번호를 확인하세요');
	}

	if(result == 'Delcomsuccess'){
		alert('업체가 삭제 되었습니다');
	}
	
	

</script>
	

	<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">업체등록</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center" >
	
	<!-- 내용이 들어갈곳  -->
	<form  action="../comreg/register" method="get">
		<br /><br /><br /><br /><br /><br /><br /><br /><br />
	    <div class="form-group row" style="width: 100%;">
	        <label class="col-sm-3 text-rigth control-label col-form-label">등록번호 조회</label>
	        <div class="col-sm-5">
	            <input type="text" class="form-control " id ="bnum" name="bnum" placeholder="모범음식점 번호를 입력하세요" required>
	        </div>
	        </form>
	        <div class="col-sm-3 <text-left></text-left>">
		        <button type="submit" class="btn btn-warning" type="submit" id="btn_comreg">조회하기</button>
	        </div>
	    </div>
   </div>

<%@ include file="../footer.jsp" %>   			