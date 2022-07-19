<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>뉴스 삭제 완료</title>
</head>
<body>
	<script>
	if(${boardGroup}){
		if (window.confirm("뉴스가 삭제되었습니다.")) {
			window.location.href = "/boardGroup";
		}
	} else {
		window.confirm("뉴스 삭제 실패.")
	}
</script>
</body>
</html>