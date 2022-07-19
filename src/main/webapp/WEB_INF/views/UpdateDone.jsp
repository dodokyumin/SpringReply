<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>기존 뉴스 수정 완료</title>
</head>
<body>
<script>
	if(${boardGroup}){
		if (window.confirm("뉴스가 수정되었습니다.")) {
			window.location.href = "/boardGroup";
		}
	} else {
		window.confirm("뉴스 수정 실패.")
	}
</script>
</body>
</html>