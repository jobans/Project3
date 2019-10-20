<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<script type="text/javascript">
	var result = '${result}';
	
	if(result == 'PwFail'){
		alert('잘못된 아이디와 이메일입니다. 재입력 바랍니다');
	}


	var id = '${id}';
	
	if(id != null || id != " "){
		alert('당신의 아이디는 ' + id + ' 입니다');
	}
	
	
		
</script>

<title>find.jsp</title>
</head>
<body>

	<h3> 사용자 아이디 찾기</h3>
	
	<form action="/usersignup/idfind" id="form1" method=post>
	<table>
		<tr>
				<td>이름</td>
				<td><input type="text" name="u_name" id="" /></td>
				
			</tr>
			<tr>
				<td>생년월일</td>
				<td><input type="text" name="u_dob" id="" /></td>
				
			</tr>
			<tr>
				<td colspan="2">
					<button type="reset" id="btn_reset">RESET</button>
					<button type="submit" id="btn_uidfind">아이디 찾기</button>
				</td>
			</tr>
			
		</table>
	</form>	
	<br />

	
	<h3>사용자 비밀번호 찾기</h3>
	
	<form action="/usersignup/pwfind" id="form2" method=post>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="u_id" id="" /></td>
				
			</tr>
			
			<tr>
				<td>email</td>
				<td><input type="text" name="u_email" id="" /></td>
				
			</tr>
			<tr>
				<td colspan="2">
					<button type="reset" id="btn_reset">RESET</button>
					<button type="submit" id="btn_upwfind">비밀번호찾기</button>
				</td>
			</tr>
			
		</table>
	</form>	
	<br /><br />
	
	<h3>사업자 아이디 찾기</h3>
	<form action="/ownersignup/idfind" id="form3" method=post>
		<table>
			<tr>
				<td>이름</td>
				<td><input type="text" name="o_name" id="" /></td>
				
			</tr>
			<tr>
				<td>대표모범음식점번호</td>
				<td><input type="text" name="bnum" id="" /></td>
				
			</tr>
			<tr>
				<td colspan="2">
					<button type="reset" id="btn_reset">RESET</button>
					<button type="submit" id="btn_oidfind">아이디찾기</button>
				</td>
			</tr>
			
		</table>
	</form>	
	
	
	<h3>사업자 비밀번호 찾기</h3>
	
	<form action="/ownersignup/pwfind" id="form4" method=post>
		<table>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="o_id" id="" /></td>			
			</tr>
			
			<tr>
				<td>email</td>
				<td><input type="text" name="o_email" id="" /></td>				
			</tr>
			<tr>
				<td colspan="2">
					<button type="reset" id="btn_reset">RESET</button>
					<button type="submit" id="btn_opwfind">비밀번호찾기</button>
				</td>
			</tr>
			
		</table>
	</form>	

</body>
</html>