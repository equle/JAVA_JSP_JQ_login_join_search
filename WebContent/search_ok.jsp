<%@page import="dto.UserDTO"%>
<%@page import="dto.SearchDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="naver.*" %>
<% 
	String search = request.getParameter("search");
	ArrayList<SearchDTO> list = NVsearchAPI.search(search);
	int i=1;
%>

<%@ include file="top.jsp" %>
<h2>날씨 검색</h2>

	<%for(SearchDTO sdto : list) {%>
		<h3><% i++; %>. <a href = <%=sdto.getUrl() %> target="blank"><%= sdto.getTitle() %></a></h3><br><br>
<%} %>
</body>
</html>