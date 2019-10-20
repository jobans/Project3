<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>booking.jsp</title>
</head>
<body>

    <h3> 예약 page</h3>
	
	<form  method="post" action="../common/booking">
	
		<!-- 업체번호 -->
		<div>
			<label>예약자</label>
				<input type="text" class="disabled" id="u_id" name="u_id" value="${user.u_id }" required>
		</div>
		<!-- 업체명 -->
		<div>
			<label>업체명</label>
				<input type="text" class="disabled"  value="${c_name }" required>
		</div>
		<!-- 업체번호 -->
		<div>
			<label>모범음식점번호</label>
				<input type="text" class="disabled" id="bnum" name="bnum" value="${bnum }" required>
		</div>
		<!-- 날짜 -->
		<div>
			<label>예약일</label>
				<input type="date" class="disabled" id ="b_date" name="b_date"  placeholder="ex) 2019-05-05 12:30:00" required>
		</div>
		<!-- 인원수 -->
		<div>
			<label>인원수</label>
				<input type="text" class="disabled" id ="b_per" name="b_per"  required>
		</div>
		<br /><br />
		
			<div>
				<button type="submit" id="btn_booking">예약 완료</button>	
		
		</div>
				
	</form>

</body>
</html>