
<%@page import="dto.ReviewViewDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dto.ReviewDTO"%>
<%@page import="dao.ReviewDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="top.jsp"%>

<script>
	<% ArrayList<ReviewViewDTO> dtoList = (ArrayList<ReviewViewDTO>)request.getAttribute("list"); %>
</script>

<div class="container">
	<h3>영화 후기</h3>
	<hr>
	<div id="result"></div>
	<!-- 검색 결과 출력 -->
	<div class="container">					
	<div class="row">				
		<table class="table table-dark table-hover">		
			<thead>		
				<tr>	
					<th style="text-align: center;">글번호</th>
					<th style="text-align: center;">영화제목</th>
					<th style="text-align: center;">작성자</th>
					<th style="text-align: center;">글 제목</th>
					<th style="text-align: center;">영화평점</th>
<!-- 					<th style="background-color: #eeeeee; text-align: center;">코멘트</th> -->
				</tr>	
			</thead>		
			<tbody>		
				<% for(ReviewViewDTO d : dtoList){ %>
					<tr onclick="modal_show(<%=d.getNum() %>)">
				        <td style="text-align: center;"><%=d.getNum() %></td>
				        <td style="text-align: center;"><%=d.getM_title() %></td>
				        <td style="text-align: center;"><%=d.getId() %></td>
				        <td style="text-align: center;"><%=d.getR_title() %></td>
				        <td style="text-align: center;"><%=d.getR_score() %></td>
				      </tr>
				<% } %>
			</tbody>		
		</table>	
		
	<!-- The Modal -->
	<div class="modal fade" id="myModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">영화 후기</h4>
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
						<label for="u_name">작성자:</label> <input type="text"
							class="form-control" id="u_name" placeholder="작성자" name="u_name" disabled="disabled" > <!-- readonly="readonly" -->
					</div>
					<input type="hidden" id="u_num" value="">
					
					<div class="form-group">
						<label for="r_tit">후기제목:</label> <input type="text"
							class="form-control" id="r_tit" placeholder="후기제목" name="r_tit" readonly="readonly">
					</div>
					
					<div class="form-group">
						<label for="r_score">평점:</label> <input type="text"
							class="form-control" id="r_score" placeholder="1~5" name="r_score" readonly="readonly">
					</div>

					<div class="form-group">
						<label for="r_txt">후기 내용:</label>
						<textarea class="form-control" rows="5" id="r_txt" name="r_txt" readonly="readonly"></textarea >
					</div>


				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger" data-dismiss="modal" id="close_modal">Close</button>
				</div>

			</div>
		</div>
	</div>
	<!-- The Modal -->		
	</div>				
</div>					
</div>

<script>
	function modal_show (num) {
	    $("#myModal").modal("show");
	//     console.log(title);
	//     alert(num);
	
		$.post("reviewdetail.nhn", 
			{
				r_num : num
				
			}, function(data, status){
				console.log(data);
				
				
				console.log(data.m_title);
				console.log(data.id);
				console.log(data.r_title);
				console.log(data.r_score);
				
				$("#m_tit").val(data.m_title);
			    $("#u_name").val(data.id);
			    $("#r_tit").val(data.r_title);
			    $("#r_score").val(data.r_score);
			    $("#r_txt").val(data.r_text);

		});
	}

	$(document).ready(function() {
		$("#close_modal").click(function() {
	 		$("#myModal").modal("hide");
		});
		
	});
</script>
</body>
</html>