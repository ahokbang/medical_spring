<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>회원가입</title>
	</head>
	<body>
		<h2>회원가입</h2>
		<form action="doMember" name="frm" method="get">
			<label>아이디</label>
			<input type="text" id="id" name="id"><br>
			<label>비밀번호</label>
			<input type="password" id="pw" name="pw"><br>
			<label>이름</label>
			<input type="text" id="name" name="name"><br>
			<label>전화번호</label>
			<input type="text" id="phone" name="phone"><br>
			<label>[ 성별 ]</label><br>
			<input type="radio" name="gender" value="male">
			<label>남자</label>
			<input type="radio" name="gender" value="female">
			<label>여자</label><br>
			<label>[ 취미 ]</label><br>
			<input type="checkbox" name="hobby" value="game">
			<label for="game">게임</label>			
			<input type="checkbox" name="hobby" value="read">
			<label for="read">독서</label>		
			<input type="checkbox" name="hobby" value="workout">
			<label for="workout">운동</label>			
			<input type="checkbox" name="hobby" value="sing">
			<label for="sing">노래</label><br>
			<br>
			<input type="submit" value="전송">
		</form>
	</body>
</html>