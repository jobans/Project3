<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>no_select.jsp</title>
</head>
<body>
	<!-- 업체번호 -->
		<div>
			<label>업체번호</label>
				<input type="text" class="disabled" id="bnum"  value="${bnum }" required>
		</div>
		<!-- 업체명 -->
		<div>
			<label>업체명</label>
				<input type="text" class="disabled" id="c_name" value="${c_name }" required>
		</div>
		<!-- 제목 -->
		<div>
			<label>제목</label>
				<input type="text" class="disabled" id ="n_subject"  value="${nvo.n_subject }" required>
		</div>
		<!-- 내용 -->
		<div>
			<label>내용</label>
				<input type="text" class="disabled" id ="n_contents" value="${nvo.n_contents }"  required>
		</div>
		<br /><br />
		
			<div>
				<button type="submit" id="btn_check"><a href="/common/r_site?bnum=${bnum }">확인</a></button>	
		
		</div>

</body>
</html>