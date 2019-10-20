<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>r_site</title>
</head>
<body>

	<div>
	<!--사진파일 호출  -->
	
	</div>

	<div>
	<!-- 업체 타이틀  -->
		<table>
			<tr>
				<th><h3>${c_name }</h3></th>
				<th><h4>${cvo.c_score }</h4></th>
				<th>
					<button type="submit" id="btn_revwrite"><a href="/comreg/revwrite }">리뷰쓰기</a></button>

				</th>
			</tr>
	
		</table>
	</div>
	
	<div>
		<table>
			<tr>
				<th>h5 </th>
				<th>h5</th>
			</tr>
		</table>
	</div>
	
	<div>
	<!-- 업체 정보 불러오기  -->
		<table>
			<tr>
				<th>${cdbvo.c_add }</th>
				<th>${cdbvo.c_phone }</th>
				<th>${cvo.c_menu }</th>
				<th>${cvo.c_price }</th>
				<th>${cvo.c_parking }</th>
				<th>${cvo.c_time }</th>
				<th>${cvo.c_last }</th>
			</tr>
		
		</table>
	</div>
	
	<div>
	<!--리뷰 리스트  타이틀-->
		<table>
			<tr>
				<th>이용자 아이디</th>
				<th>제목</th>
				<th>내용</th>
				<th>별점</th>
				<th>등록날짜</th>				
				<th>최신 업데이트</th>	
				<th>사진 파일</th>			
							
			</tr>
			
			<c:forEach var="rvo" items="${rlist }">
				<tr>
					<td>${rvo.u_id }</td>
					<td>${rvo.r_name }</td>
					<td>${rvo.r_contents }</td>
					<td>${rvo.r_score }</td>
					<td>${rvo.r_date }</td>
					<td>${rvo.r_redate }</td>
					<td></td>
	
				</tr>
			</c:forEach>
		
		</table>	
	</div>
	
	<div>
	<!-- 리뷰 리스트-->
	</div>

</body>
</html>