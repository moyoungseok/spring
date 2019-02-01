<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<title>회원가입</title>

<style>
	.send-button{
	background: #54C7C3;
	width:100%;
	font-weight: 600;
	color:#fff;
	padding: 8px 25px;
	}
	input[type=number]::-webkit-inner-spin-button, 
	input[type=number]::-webkit-outer-spin-button { 
	  -webkit-appearance: none; 
	  margin: 0; 
	}
	.g-button{
	color: #fff !important;
	border: 1px solid #EA4335;
	background: #ea4335 !important;
	width:100%;
	font-weight: 600;
	color:#fff;
	padding: 8px 25px;
	}
	.my-input{
	box-shadow: inset 0 1px 2px rgba(0, 0, 0, 0.1);
	cursor: text;
	padding: 8px 10px;
	transition: border .1s linear;
	}
	.header-title{
	margin: 5rem 0;
	}
	h1{
	font-size: 31px;
	line-height: 40px;
	font-weight: 600;
	color:#4c5357;
	}
	h2{
	color: #5e8396;
	font-size: 21px;
	line-height: 32px;
	font-weight: 400;
	}
	.login-or {
	position: relative;
	color: #aaa;
	margin-top: 10px;
	margin-bottom: 10px;
	padding-top: 10px;
	padding-bottom: 10px;
	}
	.span-or {
	display: block;
	position: absolute;
	left: 50%;
	top: -2px;
	margin-left: -25px;
	background-color: #fff;
	width: 50px;
	text-align: center;
	}
	.hr-or {
	height: 1px;
	margin-top: 0px !important;
	margin-bottom: 0px !important;
	}
	@media screen and (max-width:480px){
	h1{
	font-size: 26px;
	}
	h2{
	font-size: 20px;
	}
	}
</style>
<script>
	$(document).ready(function(){
		var checkFlag = 0;
		$("#submitBtn").click(function(){
			var userId=$("#userId").val();
			var userPw=$("#userPw").val();
			var pwd2=$("#pwd2").val();
			var userName=$("#userName").val();
			var uesrEmail=$("#userEmail").val();
			var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(userId =="" || !(/^[a-z][a-z0-9]{3,11}$/.test(userId))){
				alert("아이디를 입력해주세요 (영소문자, 숫자 4~12자)");
			}else if(userPw=="" || !(/^[a-z0-9][a-z0-9]{3,14}$/i.test(userPw)) ){
				alert("비밀번호를 입력해주세요(영소문자, 숫자  4~15자)");
			}else if(pwd2==""){
				alert("비밀번호를 확인해주세요");
			}else if(pwd2 != userPw){
				alert("비밀번호가 같지 않습니다");
			}else if(userName == ""){
				alert("이름을 입력해주세요");
			}else if(uesrEmail == ""){
				alert("이메일을 입력해주세요");
			}else if(!emailRegExp.test(uesrEmail)){
				alert("이메일 형식을 확인해주세요");
			}else if(checkFlag ==0){
				alert("ID 중복확인을 진행해주세요");
			}else{
				
				document.join.action="/userRegister";
				document.join.submit();
			}
		});
		$("#idCheck").click(function(){
			var userId=$("#userId").val();
			if(userId=="" || !(/^[a-z][a-z0-9]{3,11}$/.test(userId))){
				alert("아이디를 입력해주세요 (영소문자, 숫자 4~12자)");
			}else{
				$.ajax({
					url :"/idCheck",
					type : "POST",
					data : {userId : userId},
					success : function(data){
						console.log(data);
						if(data == true){
							alert("이미 존재하는 아이디입니다");
							checkFlag=0;
						}else{
							alert("사용 가능한 아이디 입니다");
							checkFlag=1;
						}
					}
				});	
			}
		});
	});

</script>
</head>
<body>
 <jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<div class="container">
       <div class="col-sm-6 col-md-offset-3">
         <div class="header-title">
            <h1 class="wv-heading--title">
               	회원가입
            </h1>
         </div>
      </div>
      <div class="row">
         <div class="col-sm-6 col-md-offset-3">
            <div class="myform form ">
               <form method="post" name="join" id="join">
               <input type="hidden" name="uniqId" id="uniqId" value="${uniqId}"/>
                  <div class="form-group">
                  	<label for="inputId">아이디</label>
                  	 <table>
                  	 	<tr>
                  	 		<td width="90%"><input type="text" name="userId" id="userId" class="form-control my-input" placeholder="아이디를 입력하세요"></td>
                  	 		<td><button type="button" onclick="return idCheck();" id="idCheck" class="btn btn-info">중복체크</button></td>
                  	 	</tr>
                  	 </table>
                  </div>
                  <div class="form-group">
                  	<label for="inputPwd">비밀번호</label>
                     <input type="password" name="userPw" id="userPw" class="form-control my-input" id="password" placeholder="비밀번호를 입력하세요">
                     <p id="pwdMsg" style="color:red;"></p>
                     <span></span>
                  </div>
                  <div class="form-group">
                  	<label for="pwdCheck">비밀번호 확인</label>
                     <input type="password" name="pwdCheck" id="pwd2"  class="form-control my-input" id="pwdCheck" placeholder="비밀번호 확인을 위해 다시한번 입력 해 주세요">
                     <p id="pwdCheckMsg" style="color:red;"></p>
                     <span></span>
                  </div>
                  <div class="form-group">
                  	<label for="inputName">이름</label>
                     <input type="text" name="userName"  class="form-control my-input" id="userName" placeholder="이름을 입력하세요">
                  </div>
                  <div class="form-group">
                  	<label for="inputEmail">이메일</label>
                  	<input type="email" name="userEmail" class="form-control my-input" id="userEmail" placeholder="이메일을 입력하세요">
                  </div>
                    <div class="text-center">
                     <button type="button" id="submitBtn" class=" btn btn-block send-button tx-tfm">Create Your Free Account</button>
                    </div>
               </form>
              </div>
            </div>
         </div>
      </div>
</body>
</html>