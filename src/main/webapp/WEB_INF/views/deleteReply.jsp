<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� ����</title>
</head>
<body>
	<script>
	if(${boardGroupId}){
		if (window.confirm("����� �����Ǿ����ϴ�.")) {
			window.location.href = "/readOne?strId=${boardGroupId}";
		}
	} else {
		window.confirm("��� ���� ����.")
	}
</script>
</body>
</html>