
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
	<h3>영화 후기</h3>
	<hr>
	<div id="result"></div>
	<!-- 검색 결과 출력 -->
	<div class="container">					
	<div class="row">				
		<table class="table table-striped"			
			style="text-align: center; border: 1px solid #dddddd">		
			<thead>		
				<tr>	
					<th style="background-color: #eeeeee; text-align: center;">글번호</th>
					<th style="background-color: #eeeeee; text-align: center;">영화제목</th>
					<th style="background-color: #eeeeee; text-align: center;">작성자</th>
					<th style="background-color: #eeeeee; text-align: center;">영화평점</th>
					<th style="background-color: #eeeeee; text-align: center;">코멘트</th>
				</tr>	
			</thead>		
			<tbody>		
				<tr>	
					<td>1</td>
					<td>반도</td>
					<td>홍길동</td>
					<td>0.1</td>
					<td>잼</td>
				</tr>	
			</tbody>		
		</table>			
		<button type="button" class="btn btn-success">후기작성</button>		
	</div>				
</div>					
</div>
<!-- 
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
				html += "<a href="+field.url +" target= _blank >" + "<img src =" + field.src + "><br>"
				html += field.title +"</a><br><hr>"
				$("#result").html(html);
			});
		});
	});
</script> -->
</body>
</html>