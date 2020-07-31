<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% UserDTO dto = (UserDTO)session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	<% if (dto == null){ %>
		alert("이메일과 패스워드를 확인하세요");
		location.href = "login.nhn";
	<%} else{ %>
		location.href = "main.nhn";	
	<%}%>
	
</script>
</body>
</html>