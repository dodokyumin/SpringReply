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
	if(${boardItem}){
		if (window.confirm("����� ��ϵǾ����ϴ�.")) {
			//window.location.href = "/readOne/${boardGroup.id}";
			window.go(-2);
		}
	} else {
		window.confirm("��� ��� ����.")
	}
	
	</script>
</body>
</html>