<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>���� ���� �Ϸ�</title>
</head>
<body>
	<script>
	if(${boardGroup}){
		if (window.confirm("������ �����Ǿ����ϴ�.")) {
			window.location.href = "/boardGroup";
		}
	} else {
		window.confirm("���� ���� ����.")
	}
</script>
</body>
</html>