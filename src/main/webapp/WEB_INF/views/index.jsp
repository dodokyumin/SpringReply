<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>게시판</title>
</head>
<body>
	<h1>
		<a href="http://localhost:8090/boardGroup">스프링 뉴스</a>
	</h1>
	<table cellspacing=1 width=900 border=1>
		<tr style="background-color: grey;">
			<th width=100px>아이디</th>
			<th width=100px>글쓴이</th>
			<th width=100px>등록일</th>
			<th width=400px>글제목</th>
			<th width=100px>조회수</th>
		</tr>
		<c:choose>
			<c:when test="${boardGroupTotalCount == 0}">
				<tr>
					<td colspan="6" style="text-align: center">게시글이 없습니다.</td>
				</tr>
			</c:when>
			<c:otherwise>
				<c:forEach var="boardGroup" items="${boardGroupList.content}">
					<!-- page타입을 받으면 .content로 한번 꺼내주고 나서 반복문을 돌려야한다. -->
					<tr>
						<td style="text-align: center">${boardGroup.id}</td>
						<td style="text-align: center">${boardGroup.author}</td>
						<td style="text-align: center">${boardGroup.created}</td>
						<td><a href="/readOne?strId=${boardGroup.id}">${boardGroup.title}</a></td>
						<td style="text-align: center">${boardGroup.view}</td>
					</tr>
				</c:forEach>
			</c:otherwise>
		</c:choose>
	</table>
	<input type="button" value="신규" onclick="location.href='/createOne'">
	<br>



	<!-- 페이지네이션 -->
	<c:if test="${isItSearch == false}">
		<c:if test="${boardGroupTotalCount != 0}">
			<c:if test="${pagination.ppPage != 0 && pagination.pPage != 0}">
				<a href='/boardGroup?strCurrPage=${pagination.ppPage}'> << </a>
				<a href='/boardGroup?strCurrPage=${pagination.pPage}'> < </a>
			</c:if>
			<c:forEach var="noPage" begin="${pagination.firstPage}"
				end="${pagination.lastPage}">
				<c:if test="${noPage != 0}">
					<c:choose>
						<c:when test="${noPage == pagination.cPage}">
							<b><a style='text-decoration: underline;'
								href='/boardGroup?strCurrPage=${noPage}'>${noPage}</a></b>
						</c:when>
						<c:when test="${noPage != pagination.getcPage()}">
							<a href='/boardGroup?strCurrPage=${noPage}'>${noPage}</a>
						</c:when>
					</c:choose>
				</c:if>
			</c:forEach>

			<c:if test="${pagination.nnPage != 0 && pagination.nPage != 0}">
				<a href='/boardGroup?strCurrPage=${pagination.nPage}'> > </a>
				<a href='/boardGroup?strCurrPage=${pagination.nnPage}'> >> </a>
			</c:if>
		</c:if>
	</c:if>



	<!-- 키워드 있을 때 -->
	<c:if test="${isItSearch == true}">
		<c:if test="${boardGroupTotalCountKeyword != 0}">
			<c:if test="${pagination.ppPage != 0 && pagination.pPage != 0}">
				<a
					href='/boardGroup/search?title=${keyword}&strCurrPage=${pagination.ppPage}'>
					<< </a>
				<a
					href='/boardGroup/search?title=${keyword}&strCurrPage=${pagination.pPage}'>
					< </a>
			</c:if>
			<c:forEach var="noPage" begin="${pagination.firstPage}"
				end="${pagination.lastPage}">
				<c:if test="${noPage != 0}">
					<c:choose>
						<c:when test="${noPage == pagination.cPage}">
							<b><a style='text-decoration: underline;'
								href='/boardGroup/search?title=${keyword}&strCurrPage=${noPage}'>${noPage}</a></b>
						</c:when>
						<c:when test="${noPage != pagination.getcPage()}">
							<a
								href='/boardGroup/search?title=${keyword}&strCurrPage=${noPage}'>${noPage}</a>
						</c:when>
					</c:choose>
				</c:if>
			</c:forEach>

			<c:if test="${pagination.nnPage != 0 && pagination.nPage != 0}">
				<a
					href='/boardGroup/search?title=${keyword}&strCurrPage=${pagination.nPage}'>
					> </a>
				<a
					href='/boardGroup/search?title=${keyword}&strCurrPage=${pagination.nnPage}'>
					>> </a>
			</c:if>
		</c:if>
	</c:if>
	<br>
	<form action="/boardGroup/search" method="get">
		<input type="hidden" name="strCurrPage" value="1"> <input
			type="text" name="title"> <input type="submit" value="검색">
	</form>
</body>
</html>