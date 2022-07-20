<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
</head>
<body>
	<h1>스프링 뉴스</h1>
	<table cellspacing=1 width=900 border=1>
		<tr style="background-color: grey;">
			<th width=100px>아이디</th>
			<th width=100px>글쓴이</th>
			<th width=100px>등록일</th>
			<th width=400px>글제목</th>
			<th width=100px>조회수</th>
		</tr>

		<c:if test="${boardGroupList == null}">
			<tr>
				<td colspan="6" style="text-align: center">게시글이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="boardGroup" items="${boardGroupList.content}">
			<!-- page타입을 받으면 .content로 한번 꺼내주고 나서 반복문을 돌려야한다. -->
			<tr>
				<td style="text-align: center">${boardGroup.id}</td>
				<td style="text-align: center">${boardGroup.author}</td>
				<td style="text-align: center">${boardGroup.created}</td>
				<td><a href="readOne/${boardGroup.id}">${boardGroup.title}</a></td>
				<td style="text-align: center">${boardGroup.view}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="신규" onclick="location.href='/createOne'">
	<input type="button" value="초기화" onclick="location.href='/deleteAll'">
	<br>
	<c:if test="${boardGroupTotalCount != 0}">
		<c:if test="${pagination.ppPage != 0 && pagination.pPage != 0}">
			<a href='/boardGroup/${pagination.ppPage}'> << </a>
			<a href='/boardGroup/${pagination.pPage}'> < </a>
		</c:if>
		<c:forEach var="noPage" begin="${pagination.firstPage}"
				end="${pagination.lastPage}">
			<c:if test="${noPage != 0}">
				<c:choose>
					<c:when test="${noPage == pagination.cPage}">
						<b><a style='text-decoration: underline;'
							href='/boardGroup/${noPage}'>${noPage}</a></b>
					</c:when>
					<c:when test="${noPage != pagination.getcPage()}">
						<a href='/boardGroup/${noPage}'>${noPage}</a>
					</c:when>
				</c:choose>
			</c:if>
		</c:forEach>

		<c:if test="${pagination.nnPage != 0 && pagination.nPage != 0}">
			<a href='/boardGroup/${pagination.nPage}'> > </a>
			<a href='/boardGroup/${pagination.nnPage}'> >> </a>
		</c:if>
	</c:if>


</body>
</html>