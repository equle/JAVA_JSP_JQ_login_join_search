
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

	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">영화 후기 작성</h4>
					<button type="button" class="close" data-dismiss="modal">&times;</button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">

					<div class="form-group">
						<label for="m_tit">영화제목:</label> <input type="text"
							class="form-control" id="m_tit" placeholder="영화제목" name="m_tit" disabled="disabled">
					</div>
					<input type="hidden" id="m_num" value="">
					<div class="form-group">
						<label for="name">작성자:</label> <input type="text"
							class="form-control" id="u_name" placeholder="작성자" name="name" disabled="disabled" > <!-- readonly="readonly" -->
					</div>
					<input type="hidden" id="u_num" value="">
					<div class="form-group">
						<label for="r_tit">후기제목:</label> <input type="text"
							class="form-control" id="r_tit" placeholder="후기제목" name="r_tit">
					</div>
					
					<div class="form-group">
						<label for="r_score">평점:</label> <input type="text"
							class="form-control" id="r_score" placeholder="1~5" name="r_score">
					</div>

					<div class="form-group">
						<label for="r_txt">후기 작성:</label>
						<textarea class="form-control" rows="5" id="r_txt" name="r_txt"></textarea>
					</div>


				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary" id="okBTN">작성완료</button>
					<button type="button" class="btn btn-danger" data-dismiss="modal" id="close_modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<!-- The Modal -->
</div>
<script>
function modal_show (num) {
    $("#myModal").modal("show");
    var title = $("#mv"+ num).val();
//     console.log(title);
//     alert(num);
//     alert(title);
//값 넣기
    $("#m_tit").val(title);
    $("#m_num").val(num);
    $("#u_num").val('<%=dto.getNum()%>');
    $("#u_name").val('<%=dto.getName()%>');
}

$(document).ready(function(){
 	$("#close_modal").click(function() {
 		$("#myModal").modal("hide");
	});
 	
 	$("#okBTN").click(function() {
 		//값 가져오기
 		var m_title = $("#m_num").val();
 		var u_name = $("#u_num").val();
 		var r_title = $("#r_tit").val();
 		var r_text = $("#r_txt").val();
 		var r_score = $("#r_score").val();
 		
 		console.log(m_title);
 		console.log(u_name);
 		console.log(r_title);
 		console.log(r_text);
 		console.log(r_score);

	$.post("reviewok.nhn", 
		{
			m_num : m_title,
			u_num : u_name,
			r_title : r_title,
			r_text : r_text,
			r_score : r_score
		}, function(data, status){
	    	console.log(data);
		});
	});
 	
    $.get("movieok.nhn", 
    function(data, status){
    	var html = "";
    	console.log(data);
//     	console.log(data.items);
    	$.each(data, function(key, field){
    		console.log(key);	
    		console.log(field);	
//     		html += "<a href='" + field.url + "' target='_blank'>"
    		html += "<a href='#' target='_blank'>"
    		html += "<img src='" + field.src + "'></a><br>";
    		html += field.title + "<br>";
    		html += field.dt + "<br>";
    		html += field.at + "<br>";
    		html += "<input type='hidden' id='mv"+field.num+"' value='" + field.title + "'>";
//     		html += "<button type='button' class='btn btn-success' onclick='modal_show('\ "+ field.num +"'\)'>후기작성</button><br>>";
    		html += "<button type='button' class='btn btn-success' onclick='modal_show("+ field.num +")'>후기작성</button><br>";
          });
		$("#result").html(html);
    });
});
</script>
</body>
</html>