<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>댓글 추가 완료</title>
</head>
<body>
	<script>
	if(${boardGroup}){
		if (window.confirm("댓글이 등록되었습니다.")) {
			window.location.href = "/readOne?strId=${boardGroup}";
		}
	} else {
		window.confirm("댓글 등록 실패.")
	}
	</script>
</body>
</html>