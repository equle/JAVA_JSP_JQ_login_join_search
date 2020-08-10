
<%@page import="dto.MovieDTO"%>
<%@page import="dto.MovieselectDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<% if (dto == null) { %>
<script>
	alert("로그인을 해야 이용 가능한 서비스 입니다.");
	location.href = 'login.nhn';
</script>
<% } %>

<%
	ArrayList<MovieDTO> list = (ArrayList<MovieDTO>)request.getAttribute("movieList");

%>

<div class="container">
	<h3>영화 랭킹 출력</h3>
	<hr>
	<% for(MovieDTO l : list){%>
			<img alt="" src="<%=l.getSrc() %>">
	<% } %>
	
</div>

<script>

</script>
</body>
</html>