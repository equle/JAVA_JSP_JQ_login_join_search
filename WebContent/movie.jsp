
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<% if (dto == null) { %>
<script>
	alert("로그인을 해야 이용 가능한 서비스 입니다.");
	location.href = 'login.nhn';
</script>
<% } %>

<div class="container">
	<h3>영화 랭킹 출력</h3>
	<hr>
	<div id="result"></div>
	<!-- 검색 결과 출력 -->
	<!-- 이미지, 제목, url 
	<a href='#' class='btn btn-info' role='button'>Link Button</a>
	-->
	
</div>

<script>

	$(document).ready(function() {
		var sc = $("#search").val();
		$("#result").html("result : " + sc);
		console.log(sc);
		$.get("movieok.nhn", {
// 			search : sc
		}, function(data, status) {
			var html = "";
			$.each(data, function(key, field) {
// 				alert('key:'+ key +', title:'+field.title+',url:'+field.url);
// 				html += "<a href="+field.url + "target= _blank >
				html += "<img src =" + field.src + "><p>"+field.title +"</p>"
				html += "<p> 감독 : "+field.dt +"</p>"
				html += "<p> 감독 : "+field.at +"</p>"
				html += "<a href='write.nhn?num="+ field.num +"' class='btn btn-info' role='button'>후기작성</a><hr>"
				$("#result").html(html);
			});
		});
	});
</script>
</body>
</html>