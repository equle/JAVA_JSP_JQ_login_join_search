<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<title>join page</title>
<head>
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

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->



<%@ include file="top.jsp" %>

	<div class="container">

		<hr>

		<div class="card bg-light">
			<article class="card-body mx-auto" style="max-width: 400px;">
				<h4 class="card-title mt-3 text-center">회원가입</h4>
				<p class="text-center">회원가입을 하세요!!</p>

				<p class="divider-text">
					<span class="bg-light">join</span>
				</p>
				<form action="joinok.nhn" >
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-user"></i>
							</span>
						</div>
						<input name="name" id="name" class="form-control" placeholder="Name" type="text">
					</div>
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-envelope"></i>
							</span>
						</div>
						<input name="email" id="email" class="form-control" placeholder="Email"
							type="email">
					</div>
					<div class="form-group input-group">
							<div class="alert alert-success" id="alert-success-email">사용할수 있는 이메일 입니다.</div>
							<div class="alert alert-danger" id="alert-danger-email">해당 이메일을 사용할 수 없습니다.</div>
					</div> <!-- form-group// -->
					<!-- form-group// -->
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-phone"></i>
							</span>
						</div>
						<select name="phone1" class="custom-select" style="max-width: 120px;">
							<option value="010" selected="">010</option>
							<option value="011">011</option>
							<option value="051">051</option>
							<option value="019">019</option>
						</select> <input name="phone2" id="phone2" class="form-control" placeholder="Phone number"
							type="text">
					</div> <!-- form-group// -->

					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input name="pw" id="pw" class="form-control" placeholder="Create password" type="password">
					</div> <!-- form-group// -->
					
					<div class="form-group input-group">
						<div class="input-group-prepend">
							<span class="input-group-text"> <i class="fa fa-lock"></i>
							</span>
						</div>
						<input class="form-control" placeholder="Repeat password" type="password" id="repw">
					</div> <!-- form-group// -->
					
					<div class="form-group input-group">
							<div class="alert alert-success" id="alert-success">비밀번호가 일치합니다.</div>
							<div class="alert alert-danger" id="alert-danger">비밀번호가 일치하지 않습니다.</div>
					</div> <!-- form-group// -->
					
					<div class="form-group">
						<button type="submit" id="submit" class="btn btn-primary btn-block"> 회원가입 </button>
					</div> <!-- form-group// -->
					
					<p class="text-center"> 아이디가 있으신가요? <a href="login.nhn">Log In</a>
					</p>
				</form>
			</article>
		</div>
		<!-- card.// -->
		<hr>
	</div>
	<!--container end.//-->

	<br>
	<br>

<script type="text/javascript">


    $(function(){
        $("#submit").attr("disabled", "disabled");
        $("#alert-success").hide();
        $("#alert-danger").hide();
        $("#repw").keyup(function(){
            var pwd1=$("#pw").val();
            var pwd2=$("#repw").val();
            var em=$("#email").val();
            var na=$("#name").val();
            var ph=$("#phone").val();
            if(em != "" && na != "" && ph != ""){
            		if(pwd1 != "" || pwd2 != ""){
                        if(pwd1 == pwd2){
                            $("#alert-success").show();
                            $("#alert-danger").hide();
                            $("#submit").removeAttr("disabled");
                        }else{
                            $("#alert-success").hide();
                            $("#alert-danger").show();
                            $("#submit").attr("disabled", "disabled");
                        }
                    }
        		}
        	});

	});

	$(document).ready(function() {
		$("#alert-success-email").hide();
		$("#alert-danger-email").hide();
		$("#email").blur(function() {
			console.log("포커스를 벗어났습니다.")
			//포커스를 벗어났을 경우 아작스를 이용하여 db에 있는 이메일의 일치를 확인하여 해당 이메일과 같은 이메일이 있는지 확인하여 j쿼리를 이용하여 사용할 수 있는지 없는지 알수 있게 된다.
			var em = $("#email").val();
			$.post("emailck.nhn", {
				email : em
			}, function(data, status) {
				if (data.trim() == "true") {
					$("#alert-success-email").hide();
					$("#alert-danger-email").show();
				} else {
					$("#alert-success-email").show();
					$("#alert-danger-email").hide();

				}
			});
		});
		
		$("#phone2").focus(function() {
			$("#alert-success-email").hide();
			$("#alert-danger-email").hide();
		});
	});
</script>

</body>
</html>