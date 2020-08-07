
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
    request.setCharacterEncoding("UTF-8");
   	String num =request.getParameter("num");
%>

<div class="container">
	<h3>영화 후기</h3>
	<hr>
<!-- 	<div id="result"></div> -->
	<!-- 게시판-->
			<form method="post" action="writeAction.jsp">
				<table class="table table-striped"
					style="text-align: center; border: 1px solid #dddddd">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #eeeeee; text-align: center;">리뷰</th></tr>
					</thead>
					<thead>
						<tr>
							<th colspan="2" style="background-color: #eeeeee; text-align: center;">
							
								영화제목 : 
								글쓴이 : <%= dto.getName() %>
						
							</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="글 제목" name="" maxlength="50" value=""></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용" name="" maxlength="2048" style="height: 350px;" >여기내용 들어나</textarea></td>
						</tr>
					</tbody>
				</table>	
				<input type="submit" class="btn btn-primary pull-right" value="글쓰기" />
			</form>
</div>
<script>

	$(document).ready(function() {
		var num = $(<%= num %>).val();
// 		$("#result").html("result : " + sc);
// 		console.log(sc);
		$.get("writeok.nhn", {
			num : num
// 			search : sc
		}, function(data, status) {
			var html = "";
			$.each(data, function(key, field) {
// 				alert('key:'+ key +', title:'+field.title+',url:'+field.url);
// 				html += "<a href="+field.url + "target= _blank >
// 				html += "<img src =" + field.src + "><p>"+field.title +"</p>"
// 				html += "<p> 감독 : "+field.dt +"</p>"
// 				html += "<p> 감독 : "+field.at +"</p>"
// 				html += "<a href='write.nhn?num="+ field.num +"' class='btn btn-info' role='button'>후기작성</a><hr>"
// 				$("#result").html(html);
			});
		});
	});
</script>
</body>
</html>