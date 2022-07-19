<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>신규 뉴스 추가 완료</title>
</head>
<body>
<script>
	if(${boardGroup}){
		if (window.confirm("뉴스가 등록되었습니다.")) {
			window.location.href = "/boardGroup";
		}
	} else {
		window.confirm("뉴스 등록 실패.")
	}
	
	</script>
</body>
</html>