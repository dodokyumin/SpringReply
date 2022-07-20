<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>뉴스 상세</title>
</head>
<body>
	<h1>뉴스 상세</h1>
	<table cellspacing=1 width=600 border=1>
		<tr>
			<td width=100px style="background-color: grey;">글번호</td>
			<td>${boardGroup.id}</td>
		</tr>
		<tr>
			<td width=100px style="background-color: grey;">글제목</td>
			<td>${boardGroup.title}</td>
		</tr>
		<tr>
			<td width=100px style="background-color: grey;">글쓴이</td>
			<td>${boardGroup.author}</td>
		</tr>
		<tr>
			<td width=100px style="background-color: grey;">등록일</td>
			<td>${boardGroup.created}</td>
		</tr>
		<tr>
			<td width=100px style="background-color: grey;">조회수</td>
			<td>${boardGroup.view}</td>
		</tr>
		<tr>
			<td width=100px style="background-color: grey;">내용</td>
			<td><textarea style="width: 500px; height: 300px;"
					name="newContent" pattern='^[가-힣a-zA-Z]+$' required readonly>${boardGroup.content}</textarea></td>
		</tr>
	</table>
	<table cellspacing=1 width=400 border=0>
		<tr>
			<td width="200"></td>
			<td width="100"><p align="center">
					<input type="submit" value="수정"
						onclick="location.href='/updateOne/${boardGroup.id}'">
				</p></td>
			<td width="100"><p align="center">
					<input type="submit" value="삭제"
						onclick="location.href='/deleteOne/${boardGroup.id}'">
				</p></td>
			<td width="100"><p align="center">
					<input type="submit" value="목록"
						onclick="location.href='/boardGroup'">
				</p></td>
			<td width="100"><p align="center">
					<input type="submit" value="댓글추가"
						onclick="location.href='/createReply/${boardGroup.id}'">
				</p></td>
		</tr>
	</table>
	<h3>댓글 보기</h3>
	<table cellspacing=1 width=600 border=1>
	<c:if test="${boardItemList.size() == 0}">
			<tr>
				<td colspan="6" style="text-align: center">댓글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="boardItem" items="${boardItemList}">
			<!-- page타입을 받으면 .content로 한번 꺼내주고 나서 반복문을 돌려야한다. -->
			<tr>
				<td width=100px style="text-align: center; background-color: silver;">${boardItem.author}</td>
				<td width=400px style="text-align: center">${boardItem.title}</td>
				<td width=100px style="text-align: center"><input type="button" 
					onclick="location.href='/deleteReply/${boardItem.id}'" value="삭제"></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>