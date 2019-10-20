<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
<%@ include file="../header.jsp" %>
<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">공지사항 등록</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->

	<form  method="post">
	   
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">업체명</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " id="c_name" value="${c_name }"  readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">제목</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="n_subject" name="n_subject" placeholder="제목을 입력하세요" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">내용</label>
	        <div class="col-sm-9">
	            <textarea class="form-control" rows="5" cols="60" id ="n_contents" name="n_contents" placeholder="내용을 입력하세요"></textarea>
	        </div>
	    </div>
	    
	    <div align="center">
	    	<br />
	    	<br /><br />
	    	<button type="submit" class="btn btn-success" id="btn_no_write" name="btn_modify">저장</button>
	    </div>
	
	</form>
	</div>												
<%@ include file="../footer.jsp" %> 