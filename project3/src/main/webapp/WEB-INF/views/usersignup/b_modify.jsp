<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>b_modify</title>
</head>
<body>

	<h3> 예약 수정 page</h3>
	<br />
	<form  method="post">
	
		<!-- 업체번호 -->
		<div>
			<label>예약자</label>
				<input type="text" class="disabled" id="" name="u_id" value="${bvo.u_id }" required>
		</div>
		<!-- 업체명 -->
		<div>
			<label>업체명</label>
				<input type="text" class="disabled" id="c_name" value="${c_name }" required>
		</div>
		<!-- 업체번호 -->
		<div>
			<label>모범음식점번호</label>
				<input type="text" class="disabled" id="c_name" value="${bvo.bnum }" required>
		</div>
		<!-- 날짜 -->
		<div>
			<label>예약일</label>
				<input type="text" class="disabled" id ="b_date" name="b_date"  value="${bvo.b_date }" required>
		</div>
		<!-- 인원수 -->
		<div>
			<label>인원수</label>
				<input type="text" class="disabled" id ="b_per" name="b_per"  value="${bvo.b_per }" required>
		</div>
		<br /><br />
		
			<div>
				<button type="submit" id="btn_booking">예약 완료</button>	
		
		</div>
				
	</form>

</body>
</html>