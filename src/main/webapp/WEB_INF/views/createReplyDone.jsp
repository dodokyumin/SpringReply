<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��� �߰� �Ϸ�</title>
</head>
<body>
	<script>
	if(${boardGroup}){
		if (window.confirm("����� ��ϵǾ����ϴ�.")) {
			window.location.href = "/readOne?strId=${boardGroup}";
		}
	} else {
		window.confirm("��� ��� ����.")
	}
	</script>
</body>
</html>