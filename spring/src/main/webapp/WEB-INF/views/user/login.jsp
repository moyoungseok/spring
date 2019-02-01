<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
 
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>로그인페이지</title>
<style>
	div input{
		margin-bottom:20px;
	}
	#login{
		padding-top:100px;
	}
	#login .form-wrap{
		width:30%;
		margin: 0 auto;
	}
	#login h1{
		color:#1fa67b;
		font-align:center;
		font-weight:bold;
		padding-bottom:20px;
	}
	.btn-custom {
    color: #fff;
	background-color: #1fa67b;
	}
	#login .form-group {
	    margin-bottom: 25px;
	}
	
	#login .btn.btn-custom {
	    font-size: 14px;
		margin-bottom: 20px;
	}
	#login .forget {
	    font-size: 13px;
		text-align: center;
		display: block;
	}
	#login-form{
		padding-top:30px;
	}
	/*    --------------------------------------------------
		:: Inputs & Buttons
		-------------------------------------------------- */
	.form-control {
	    color: #212121;
	}
	.btn-custom {
	    color: #fff;
		background-color: #1fa67b;
	}
	.btn-custom:hover,
	.btn-custom:focus {
	    color: #fff;
	}
	
	/*    --------------------------------------------------
	    :: Footer
		-------------------------------------------------- */
	#footer {
	    color: #6d6d6d;
	    font-size: 12px;
	    text-align: center;
	}
	#footer p {
	    margin-bottom: 0;
	}
	#footer a {
	    color: inherit;
	}
	
	  html, div, body,h3{
  	margin: 0;
  	padding: 0;
  }
  h3{
  	display: inline-block;
  	padding: 0.6em;
  }
	
</style>
</head>
<body>
	<!-- 헤더 내비 -->
	<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	
	<div id="content">
		<section id="login">
		 <div class="container-fluid">
			 <div class="form-wrap">
	          <center><h3>로그인</h3></center>
	              <form role="form" action="/user/loginPost" method="post" id="login-form" autocomplete="off">
	                  <div class="form-group">
	                      <label for="id" class="sr-only">ID</label>
	                      <input type="text" name="userId" id="userId" class="form-control" placeholder="아이디를 입력하세요">
	                  </div>
	                  <div class="form-group">
	                      <label for="key" class="sr-only">Password</label>
	                      <input type="password" name="userPw" id="userPw" class="form-control" placeholder="비밀번호를 입력하세요">
	                  </div>
	                  <button id="btn-login" class="btn btn-custom btn-lg btn-block" onclick="return logCheck();">Log in</button>
	              </form>
	              
	              <!-- 소셜 로그인 -->
	              <!-- 구글 로그인 화면으로 이동 시키는 URL -->
					<!-- 구글 로그인 화면에서 ID, PW를 올바르게 입력하면 oauth2callback 메소드 실행 요청-->
					 <div id="google_id_login" style="text-align: center"><a href="${google_url}"> 구글 로그인 </a>
					 
		             <!-- 네이버아이디로로그인 버튼 노출 영역 -->
					  <div id="naver_id_login"></div>
					  <!-- //네이버아이디로로그인 버튼 노출 영역 -->
					  <script type="text/javascript">
					  	var naver_id_login = new naver_id_login("MHDP9axJ2LVahpvzIXYm", "http://localhost/naverCallback");
					  	var state = naver_id_login.getUniqState();
					  	naver_id_login.setButton("white", 2,40);
					  	naver_id_login.setDomain("http://localhost/login");
					  	naver_id_login.setState(state);
					  	naver_id_login.setPopup();
					  	naver_id_login.init_naver_id_login();
					  </script>
		             <a href="/register" class="register"><center>Register</center></a>
	              <hr>
		      </div>
			</div>
			</div>
		</section>
	</div>
	<script>
		function logCheck(){
			var userId = document.getElementById("userId").value;
			var userPwd = document.getElementById("userPw").value;
			
			if(userId==""){
				alert("아이디를 입력해주세요");
				return false;
			}else if(userPwd=="")
			{
				alert("비밀번호를 입력해주세요");
				return false;
			}else{
				return true;
			}
		}
	</script>
	
	
</body>

</html>
</html>