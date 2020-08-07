<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% UserDTO dto = (UserDTO)session.getAttribute("user"); %>
<!DOCTYPE html>
<html lang="en">
  <title>Main page</title>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style>
.divider-text {
	position: relative;
	text-align: center;
	margin-top: 15px;
	margin-bottom: 15px;
}

.divider-text span {
	padding: 7px;
	font-size: 12px;
	position: relative;
	z-index: 2;
}

.divider-text:after {
	content: "";
	position: absolute;
	width: 100%;
	border-bottom: 1px solid #ddd;
	top: 55%;
	left: 0;
	z-index: 1;
}

.btn-facebook {
	background-color: #405D9D;
	color: #fff;
}

.btn-twitter {
	background-color: #42AEEC;
	color: #fff;
}
</style>
</head>

<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="main.jsp">날씨 검색</a>
  
  <!-- Links -->
<ul class="navbar-nav">
  <% if(dto == null){%>
    <li class="nav-item">
      <a class="nav-link" href="login.nhn" >로그인</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="join.nhn">회원가입</a>
    </li>
  
    
    <% }else{ %>
    <li class="nav-item">
      <a class="nav-link" href="logout.nhn">로그아웃</a>
    </li>
  <% } %>
  <li class="nav-item">
      <a class="nav-link" href="search.nhn">날씨 검색</a>
   </li>
  <li class="nav-item">
      <a class="nav-link" href="food.nhn">맛집 검색</a>
   </li>
  <li class="nav-item">
      <a class="nav-link" href="movie.nhn">영화 검색</a>
   </li>
  <li class="nav-item">
      <a class="nav-link" href="review.nhn">영화 후기</a>
   </li>
  </ul>
</nav>