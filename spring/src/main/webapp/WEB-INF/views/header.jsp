<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib
    prefix="c"
    uri="http://java.sun.com/jsp/jstl/core" 
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>헤더</title>

<style>

	<!-- jumbotron -->
	.jumbotron{
    	margin-bottom: 0px;
    	padding-top:15px;
	}
	.jumbotron h1{
		margin-top:10px;
	}
	.jumbotron p{
		margin-bottom: 0px;
	}
	@media screen and (min-width: 768px)
	.jumbotron {
	    padding : 0;
	}
	
	/* 마이페이지 사이드바 */
	body {
    font-family: "Lato", sans-serif;
    transition: background-color .5s;
	}
	
	.sidenav {
	    height: 100%;
	    width: 0;
	    position: fixed;
	    z-index: 1;
	    top: 0;
	    left: 0;
	    background-color: #111;
	    overflow-x: hidden;
	    transition: 0.5s;
	    padding-top: 60px;
	}
	
	.sidenav a {
	    padding: 8px 8px 8px 32px;
	    text-decoration: none;
	    font-size: 17px;
	    color: #818181;
	    display: block;
	    transition: 0.3s;
	    font-weight:bold;
	}
	
	.sidenav a:hover {
	    color: #f1f1f1;
	}
	
	.sidenav .closebtn {
	    position: absolute;
	    top: 0;
	    right: 25px;
	    font-size: 36px;
	    margin-left: 50px;
	}
	
	
	@media screen and (max-height: 450px) {
	  .sidenav {padding-top: 15px;}
	  .sidenav a {font-size: 18px;}
	}
	
	/* 관리자 사이드바  */
	.sidenav_admin {
	    height: 100%;
	    width: 0;
	    position: fixed;
	    z-index: 1;
	    top: 0;
	    left: 0;
	    background-color: #111;
	    overflow-x: hidden;
	    transition: 0.5s;
	    padding-top: 60px;
	}
	
	.sidenav_admin a {
	    padding: 8px 8px 8px 32px;
	    text-decoration: none;
	    font-size: 17px;
	    color: #818181;
	    display: block;
	    transition: 0.3s;
	    font-weight:bold;
	}
	
	.sidenav_admin a:hover {
	    color: #f1f1f1;
	}
	
	.sidenav_admin .closebtn {
	    position: absolute;
	    top: 0;
	    right: 25px;
	    font-size: 36px;
	    margin-left: 50px;
	}

</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
	  <div class="container-fluid">
	    <div class="navbar-header">
	      <a class="navbar-brand" href="/listPage">게시판</a>
	    </div>
	    <c:if test= "${not empty login}">
	 		<ul class="nav navbar-nav navbar-right">
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> MyPage</a></li>
		      <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
	    	</ul>
	  	</c:if>
	  	<c:if test="${empty login }">
	    	<ul class="nav navbar-nav navbar-right">
		      <li><a href="/register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
		      <li><a href="/login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
	    	</ul>
	  	</c:if>
	  </div>
	</nav>
</body>
</html>