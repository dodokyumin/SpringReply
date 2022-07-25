<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>신규 댓글 추가</title>
</head>
<body>
	<h1>신규 댓글 추가</h1>
	<form action="/createReplyDone" method="post">
		<table cellspacing=1 width=600 border=1>
			<tr>
				<td width=100px>아이디</td>
				<td><input type="text" value="자동 등록" readonly></td>
			</tr>
			<tr>
				<td width=100px>원문 아이디</td>
				<td><input type="text" name="boardGroup" value="${boardGroupId}" readonly></td>
			</tr>

			<tr>
				<td width=100px>글쓴이</td>
				<td><input type="text" placeholder="제목을 입력하세요." name="author"
					pattern='^[ㄱ-ㅎ가-힣a-zA-Z0-9\s?~!@#$%^&*()/ -]+$' required></td>
			</tr>
			<%-- 	<tr>
				<td width=100px>일자</td>
				<td><input type="text" value="${newDate}" readonly></td>
			</tr> --%>
			<tr>
				<td width=100px>글내용</td>
				<td><input type="text" placeholder="제목을 입력하세요." name="title"
					pattern='^[ㄱ-ㅎ가-힣a-zA-Z0-9\s?~!@#$,.%^&*()/ -]+$' required></td>
			</tr>
			</table>
		<input type="submit" value="등록"> <input type="button"
			value="취소" onclick="location.href='/readOne/${boardGroupId}'">
	</form>
</body>
</html>