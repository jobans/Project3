<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp" %>
	

	<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">MY업체</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center" >
	
	<div class="card">

	    <table class="table">
	            <tr>
	              <!-- <th scope="col">모범음식점번호</th> -->
	              <th scope="col">업체명</th>
	              <th scope="col">평점</th>
	              <th scope="col"></th> <!-- 상세보기 -->
	              <th scope="col"></th> <!-- 공지사항 -->
	              <th scope="col"></th> <!-- 통계 -->
	              <th scope="col"></th> <!-- 삭제 -->
	            </tr>
	     	  <c:forEach var="cvo" items="${clist}">
	            <tr>
	             <%--  <td>${cvo.bnum }</td> --%>
	              <td>${cvo.c_name }</td>
	              <td>${cvo.c_score }</td>
	              <td><a href="/comreg/comaccount?bnum=${cvo.bnum }"><button type="submit" id="btn_cdetail" class="btn btn-outline-warning">상세보기</button></a></td>
	              <td><a href="/comreg/noticelist?bnum=${cvo.bnum }"><button type="submit" id="btn_cdetail" class="btn btn-outline-primary">공지사항</button></a></td>
	              <td><button type="submit" id="btn_delcom" class="btn btn-outline-danger">통계</button></td>
	              <td><button type="submit" id="btn_delcom" class="btn btn-outline-danger">삭제</button></td>
	            </tr>
	          </c:forEach>
	    </table>
	</div>		
</div>
<%@ include file="../footer.jsp" %>   	