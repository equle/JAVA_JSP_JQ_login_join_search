<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="top.jsp" %>
<h2>날씨 검색</h2>

<div class="card bg-light">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">날씨 검색</h4>
	<p class="text-center">검색 하세요!!</p>
	
    <div class="form-group input-group">
        <input name="search" id="search" class="form-control" placeholder="search" type="search" >
    </div> <!-- form-group// -->
    
    <div class="form-group">
        <button id="searchBTN"type="submit" class="btn btn-primary btn-block"> 검색 </button>
    </div> <!-- form-group// -->
</article>
</div> <!-- card.// -->


<div id="result"></div><!-- 검색 결과 출력 -->

<script>
	$(document).ready(function() {
		$("#searchBTN").click(function() {
		var sc = $("#search").val();
// 		$("#result").html("result : "+sc);
		console.log(sc);
			$.post("searchok.nhn", {
				search : sc
			}, function(data, status) {
				var html = "";
				$.each(data.items, function(key, field) {
					html+="<a href="+field.link +" target= _blank >"
					html+= field.title+"</a><br>"
					$("#result").html(html);						
				});
			});
		});
	});
</script>
</body>
</html>