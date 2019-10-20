<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 업체등록 성공 확인하기 위해 alert 창 띄움  -->
<script type="text/javascript">
	var result = '${result}';
	
	if(result == 'Modisuccess'){
		alert('업체정보 수정이 정상처리되었습니다');
	}
</script>
<%@ include file="../header.jsp" %>

	<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">업체정보</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->

	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">모범음식점번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " id="bnum" name="bnum" value="${com.bnum }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">ID</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " id ="o_id" name="o_id" value="${com.o_id }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">업체명</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_name" name="c_name" value="${c_name }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">가격대</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_price" name="c_price" value="${com.c_price }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">영업시간</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_time" name="c_time" value="${com.c_time }" readonly="readonly">
	        </div>
	    </div>
	      <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">라스트 오더</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_last" name="c_last" value="${com.c_last }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">메뉴</label>
	        <div class="col-sm-9">
	            <textarea class="form-control" rows="5" cols="60" id ="c_menu" name="c_menu"  readonly="readonly">${com.c_menu }</textarea>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">주차</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_parking" name="c_parking" value="${com.c_parking }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">업체소개</label>
	        <div class="col-sm-9">
	            <textarea class="form-control" rows="5" cols="60" name="c_contents" readonly="readonly">${com.c_contents }</textarea>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">키워드</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_keyword" name="c_keyword" value="${com.c_keyword }" readonly="readonly">
	        </div>
	    </div>

	    
	    <div align="center">
	    	<br />
	    	<br /><br />
	    	<a href="/comreg/modify?bnum=${com.bnum }"><button type="button" class="btn btn-warning">수정하기</button></a>
	    </div>
	
	</div>											
<%@ include file="../footer.jsp" %>