<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>신규 뉴스 추가</title>
</head>
<body>
	<h1>신규 뉴스 추가</h1>
	<form action="/createDone" method="post">
		<table cellspacing=1 width=600 border=1>
			<tr>
				<td width=100px>아이디</td>
				<td><input type="text" value="자동 등록" readonly></td>
			</tr>

			<tr>
				<td width=100px>글쓴이</td>
				<td><input type="text" placeholder="제목을 입력하세요." name="author"
					pattern='^[가-힣a-zA-Z0-9\s?~!@#$%^&*()/ -]+$' required></td>
			</tr>
			<%-- 	<tr>
				<td width=100px>일자</td>
				<td><input type="text" value="${newDate}" readonly></td>
			</tr> --%>
			<tr>
				<td width=100px>글제목</td>
				<td><input type="text" placeholder="제목을 입력하세요." name="title"
					pattern='^[가-힣a-zA-Z0-9\s?~!@#$%^&*()/ -]+$' required></td>
			</tr>
			<tr>
				<td width=100px>글내용</td>
				<td><textarea style="width: 500px; height: 300px;"
						name="content" placeholder="내용을 입력하세요."
						pattern='^[가-힣a-zA-Z0-9\s?~!@#$%^&*()/ -]+$' required></textarea></td>
			</tr>
		</table>
		<input type="submit" value="등록"> <input type="button"
			value="취소" onclick="location.href='/boardGroup'">
	</form>
</body>
</html>