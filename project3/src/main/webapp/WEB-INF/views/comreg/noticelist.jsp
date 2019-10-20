<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include file="../header.jsp" %>
	

	<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">${c_name} 공지사항</h4>
	        </div>
	    </div>
	</div>

	<div class="container-fluid" align="center" >
	<div class="card">
	 <table class="table">
	            <tr>
	           	    <th scope="col">번호</th>
					<th scope="col">업체번호</th>
					<th scope="col">업체명</th>
					<th scope="col">제목</th>
					<th scope="col">내용</th>				
					<th scope="col">날짜</th>				
					<th scope="col">조회수</th>				
					<th scope="col">수정</th>				
					<th scope="col">삭제</th>
					<th scope="col"><a href="../comreg/no_write?bnum=${bnum }"><button type="submit" id="btn_cdetail" class="btn btn-outline-primary">글쓰기</button></a></th>
	            </tr>
	     	   <c:forEach var="nvo" items="${nlist }">
				<tr>
					<td>${nvo.n_no }</td>
					<td>${nvo.bnum }</td>
					<td>${c_name}</td>
					<td>${nvo.n_subject }</td>
					<td>${nvo.n_contents }</td>
					<td>${nvo.n_date }</td>
					<td>${nvo.n_hits }</td>
					<td>
						<a href="/comreg/no_modify?n_no=${nvo.n_no }"><button type="submit" id="btn_cdetail" class="btn btn-outline-warning">수정하기</button></a>
					</td>
				
					<td>
						<a href="/comreg/no_delete?n_no=${nvo.n_no }"><button type="submit" id="btn_cdetail" class="btn btn-outline-danger">삭제하기</button></a>
					</td>
	
				</tr>
				</c:forEach>
	    </table>
	</div>

	</div>
<%@ include file="../footer.jsp" %>   	