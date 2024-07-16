<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>메인페이지</title>
	</head>
	<body>
		<h2>메인페이지</h2>
		<ul>
			<li><a href="member/login">로그인</a></li> <!-- ./ : 현재위치, ../은 한칸 앞으로 ../../ 두칸 앞으로 -->
			<li><a href="form">회원가입</a></li> <!-- 아무것도 없음 : 현재 위치 -->
			<li><a href="/logout">로그아웃</a></li> <!-- / : root 폴더에서 실행 -->
			<li><a href="boardList?bno=10">게시판</a></li>
			<li><a href="boardList2/5">게시판2</a></li>
			<li><a>회원정보</a></li>
		</ul>
	</body>
</html>