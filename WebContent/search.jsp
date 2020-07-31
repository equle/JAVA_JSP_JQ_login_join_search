<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<h2>날씨 검색</h2>

<form action="searchok.nhn" method="get">
  <label for="search">검색어 : </label>
  <input type="text" name="search" id="search">
  <input type="submit" value="검색">
</form> 
</body>
</html>