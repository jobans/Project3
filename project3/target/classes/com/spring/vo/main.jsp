<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 로그아웃 성공 확인하기 위해 alert 창 띄움  -->
<script type="text/javascript">
	var result = '${result}';
	
	if(result == 'Logoutsuccess'){
		alert('로그아웃 정상처리되었습니다');
	}
	
	if(result == 'Delsuccess'){
		alert('회원탈퇴 되었습니다')
	}
	
	
</script>
<title>main.jsp</title>
</head>
<body>

	<h3>${owner.oid } 님 환영합니다.</h3>
	
	<div>
		<button type="submit" id="btn_register"><a href="/ownersignup/logout">로그아웃</a></button>
	
	</div>
 


</body>
</html>