<%@page import="dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% UserDTO dto = (UserDTO)session.getAttribute("user"); %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Main page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <link rel="stylesheet"	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
  <!-- Brand/logo -->
  <a class="navbar-brand" href="main.jsp">날씨 검색</a>
  
  <!-- Links -->
<ul class="navbar-nav">
  <% if(dto == null){%>
    <li class="nav-item">
      <a class="nav-link" href="login.nhn">로그인</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="join.nhn">회원가입</a>
    </li>
  <% }else{ %>
    <li class="nav-item">
      <a class="nav-link" href="search.nhn">검색</a>
    </li>
       <li class="nav-item">
      <a class="nav-link" href="logout.nhn">로그아웃</a>
    </li>
  <% } %>
  </ul>
</nav>