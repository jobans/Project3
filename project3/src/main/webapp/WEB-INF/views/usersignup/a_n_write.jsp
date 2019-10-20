<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>a_n_write.jsp</title>
</head>
<body>
<h3>공지사항 등록 page</h3>
	
	<form  method="post">
	

		<!-- 제목 -->
		<div>
			<label>제목</label>
				<input type="text" class="disabled" id ="an_subject" name="an_subject"  required>
		</div>
		<!-- 내용 -->
		<div>
			<label>내용</label>
				<input type="text" class="disabled" id ="an_contents" name="an_contents"  required>
		</div>
		
		<br /><br />
		
			<div>
				<button type="submit" id="btn_a_n_write">공지사항 등록</button>	
		
		</div>
				
	</form>
	


</body>
</html>