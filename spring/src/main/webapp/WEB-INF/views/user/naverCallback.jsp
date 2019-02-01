<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>NaverLoginSDK</title>
	<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
</head>

<body>

	callback 처리중입니다.
	<script type="text/javascript">
		  var naver_id_login = new naver_id_login("MHDP9axJ2LVahpvzIXYm", "http://localhost/naverCallback");
		  /* // 접근 토큰 값 출력
		  alert("토큰 값:"+naver_id_login.oauthParams.access_token); */
		  // 네이버 사용자 프로필 조회
		  naver_id_login.get_naver_userprofile("naverSignInCallback()");
		  // 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
		  function naverSignInCallback() {
			var naverUniqId =  naver_id_login.getProfileData('id');
			var naverEmail = naver_id_login.getProfileData('email');
			var naverName = naver_id_login.getProfileData('name');
			
		    $("#uniqId").val(naverUniqId);
		 	
		    window.opener.name="parentPage"; //부모창 이름 설정
		    document.naverCheck.target="parentPage"; //타겟을 부모창으로 설정
		    document.naverCheck.action="/naverUnique";
		    document.naverCheck.submit();
		    self.close();
		  }
	</script>
	
	<form name="naverCheck" method="post">
		<input type="hidden" name="uniqId" id="uniqId" value=""/>
	</form>
	
	<form name="naverJoin" method="post">
		<input type="hidden" name="uniqId" id="uniqId" value=""/>
		<input type="hidden" name="email" id="email" value=""/>
		<input type="hidden" name="name" id="name" value=""/>
	</form>
</body>

</html>