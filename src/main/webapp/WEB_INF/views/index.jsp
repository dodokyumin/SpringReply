<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>�Խ���</title>
</head>
<body>
	<h1>������ ����</h1>
	<table cellspacing=1 width=900 border=1>
		<tr style="background-color: grey;">
			<th width=100px>���̵�</th>
			<th width=100px>�۾���</th>
			<th width=100px>�����</th>
			<th width=400px>������</th>
			<th width=100px>��ȸ��</th>
		</tr>

		<c:if test="${boardGroupList == null}">
			<tr>
				<td colspan="6" style="text-align: center">�Խñ��� �����ϴ�.</td>
			</tr>
		</c:if>
		<c:forEach var="boardGroup" items="${boardGroupList.content}">
			<!-- pageŸ���� ������ .content�� �ѹ� �����ְ� ���� �ݺ����� �������Ѵ�. -->
			<tr>
				<td style="text-align: center">${boardGroup.id}</td>
				<td style="text-align: center">${boardGroup.author}</td>
				<td style="text-align: center">${boardGroup.created}</td>
				<td><a href="readOne/${boardGroup.id}">${boardGroup.title}</a></td>
				<td style="text-align: center">${boardGroup.view}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="button" value="�ű�" onclick="location.href='/createOne'">
	<input type="button" value="�ʱ�ȭ" onclick="location.href='/deleteAll'">
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