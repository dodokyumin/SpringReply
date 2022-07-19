<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>뉴스 기사 수정</title>
</head>
<body>
	<h1>뉴스 기사 수정</h1>
	<form action="/UpdateDone/${boardGroup.id}" method="post">
		<table cellspacing=1 width=600 border=1>
			<tr>
				<td width=100px style="background-color: grey;">글번호</td>
				<td>${boardGroup.id}</td>
			</tr>
			<tr>
				<td width=100px style="background-color: grey;">글제목</td>
				<td><input type="text" name="title" value="${boardGroup.title}"></td>
			</tr>
			<tr>
				<td width=100px style="background-color: grey;">글쓴이</td>
				<td>${boardGroup.author}</td>
			</tr> 
			<tr>
				<td width=100px style="background-color: grey;">조회수</td>
				<td>${boardGroup.view}</td>
			</tr>
<%-- 			<tr>
				<td width=100px style="background-color: grey;">등록일</td>
				<td><input type="text" name="title" value="${boardGroup.created}"></td>
			</tr> --%>
			<tr>
				<td width=100px style="background-color: grey;">내용</td>
				<td><textarea style="width: 500px; height: 300px;"
						name="content" pattern='^[가-힣a-zA-Z0-9\s?~!@#$%^&*()/ -]+$'
						required>${boardGroup.content}</textarea></td>
			</tr>
		</table>
		<table cellspacing=1 width=400 border=0>
			<tr>
				<td width="200"></td>
				<td width="100"><p align="center">
						<input type="submit" value="수정">
					</p></td>
				<td width="100"><p align="center">
						<input type="button" value="취소"
							onclick="/readOne/${boardGroup.id}'">
					</p></td>
			</tr>
		</table>
	</form>
	<input type="submit" value="삭제"
		onclick="location.href='/deleteOne/${boardGroup.id}'">
</body>
</html>