<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% boolean join = (boolean)session.getAttribute("join"); %>
		<% session.invalidate(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	<% if (join){ %>
		alert("성공적으로 회원가입을 하였습니다");
		location.href = "login.nhn";
	<%} else{ %>
		alert("회원가입에 실패하였습니다.");
		location.href = "join.nhn";	
	<%}%>
	
</script>
</body>
</html>