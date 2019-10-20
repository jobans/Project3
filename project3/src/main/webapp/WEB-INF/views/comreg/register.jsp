<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!-- 업체등록 성공 확인하기 위해 alert 창 띄움  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#btn_modify").click(function(){
		$("#bnum").removeAttr("disabled");
	});
});


</script>
<%@ include file="../header.jsp" %>
<div class="page-breadcrumb">
	    <div class="row">
	        <div class="col-12 d-flex no-block align-items-center">
	            <h4 class="page-title">업체등록</h4>
	        </div>
	    </div>
	</div>
	<div class="container-fluid" align="center">
	
	<!-- 내용이 들어갈곳  -->
		<form id="form"  method="post" enctype="multipart/form-data">
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">모범음식점번호</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " id="bnum" name="bnum"  value="${bnum }" readonly="readonly">
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label class="col-sm-3 text-left control-label col-form-label">ID</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control " id ="o_id" name="o_id" value="${o_id }" readonly="readonly">
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
	            <input type="text" class="form-control" id ="c_price" name="c_price" placeholder="가격대를 입력해주세요" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">영업시간</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_time" name="c_time" placeholder="10:00 ~ 22:00" >
	        </div>
	    </div>
	      <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">라스트 오더</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_last" name="c_last" placeholder="10:00" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">메뉴</label>
	        <div class="col-sm-9">
	            <textarea class="form-control" rows="5" cols="60" id ="c_menu" name="c_menu" placeholder="오징어 : 10000원"></textarea>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">주차</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_parking" name="c_parking" placeholder="가능 or 불가능" >
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">업체소개</label>
	        <div class="col-sm-9">
	            <textarea class="form-control" rows="5" cols="60" id="c_contents" name="c_contents" placeholder="업체를 소개해주세요"></textarea>
	        </div>
	    </div>
	    <div class="form-group row" style="width: 50%;">
	        <label for="lname" class="col-sm-3 text-left control-label col-form-label">키워드</label>
	        <div class="col-sm-9">
	            <input type="text" class="form-control" id ="c_keyword" name="c_keyword" placeholder="' , ' 로 구분해 주세요">
	        </div>
	    </div>
	    <div class="inputArea">
			<label for="gdsImg">이미지</label>
			<input type="file" id="gdsImg" name="file" />
				<div class="select_img"><img src="" /></div>
			 
				 <script>
				  $("#gdsImg").change(function(){
					if(this.files && this.files[0]) {
			    		var reader = new FileReader;
			    		reader.onload = function(data) {
			     	$(".select_img img").attr("src", data.target.result).width(500);        

			    		}
			    		reader.readAsDataURL(this.files[0]);
			   			}
			  		});
			 	</script>
			 	
			 	<%=request.getRealPath("/") %>
		</div>
	    <div align="center">	
			<%-- <a href="/comreg/comaccount?bnum=${com.bnum }"><button type="button"  class="btn btn-danger btn-lg" >취소</button></a>
			&nbsp&nbsp&nbsp --%>
			<a href="../comreg/modify"><button type="submit" id="btn_register" class="btn btn-warning btn-lg">저장하기</button></a> 
      	</div>
	
		</form>
	</div>										
<%-- 
	<h3>업체 등록 page</h3>
	
	<form  method="post">
			<!-- 모범음식점 번호 -->
			<div >
				<label>모범음식점 번호</label>
				<input type="text"   value="${bnum }" >
			</div>
					
			<!-- 사업자 아이디 -->
			<div >
				<label>사업자 아이디</label>
				<input type="text"  id="o_id" name="o_id" value="${o_id }" >
			</div>
			
			<!-- 업체명 -->
			<div >
				<label>업체명</label>
				<input type="text" value="${c_name }" >
			</div>
					
			
			<!-- 가격대-->
			<div >
				<label>가격대</label>
				<input type="text"  id="c_price" name="c_price" required>
			</div>
			
			<!-- 영업시간 -->
			<div >
				<label >영업시간</label>
				<input type="text" id="c_time" name="c_time" placeholder=" 오전  ~ 오후 " required>
			</div>
			
			<!-- 마지막 주문시간 -->
			<div >
				<label >마지막 주문 가능 시간</label>
				<input type="text"   name="c_last"  required>
			</div>
			
			<!-- 메뉴 -->
			<div >
				<label >메뉴</label>
				<input type="text"   name="c_menu" placeholder="주된 음식 메뉴" required>
			</div>
			
			<!-- 주차-->
			<div >
				<label>주차 가능 여부</label>
				<input type="text" id= "c_parking"  name="c_parking"  placeholder="Y/N" required>
			</div>
			
			<!-- 키워드 -->
			<div>
				<label>키워드</label>
				<input type="text" id= "c_keyword" name="c_keyword"  required>
			</div>
			
			<!-- 업체소개 -->
			<div>
				<label>업체소개</label>
				<input type="text" id= "c_contents" name="c_contents"  required>
			</div>

			
			<div>				
				<button type="reset" id="btn_reset">RESET</button>
				<button type="submit" id="btn_register">등록하기</button>			 	        		 		
			</div>
											
	</form> --%>
	
	
	

<%@ include file="../footer.jsp" %>