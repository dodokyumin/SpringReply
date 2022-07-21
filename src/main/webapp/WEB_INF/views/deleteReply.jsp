<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>댓글 삭제</title>
</head>
<body>
	<script>
	if(${boardGroupId}){
		if (window.confirm("댓글이 삭제되었습니다.")) {
			window.location.href = "/readOne?strId=${boardGroupId}";
		}
	} else {
		window.confirm("댓글 삭제 실패.")
	}
</script>
</body>
</html>