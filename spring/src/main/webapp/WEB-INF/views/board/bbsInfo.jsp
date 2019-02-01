<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous">
 </script>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<title>bbsInfo</title>


<style>
.well{
	 background-color: #f5f5f5;
}
	/* CSS Test begin */
.comment-box {
    margin-top: 30px !important;
}
/* CSS Test end */

.comment-box img {
    width: 50px;
    height: 50px;
}
.comment-box .media-left {
    padding-right: 10px;
    width: 700px;
}
.comment-box .media-body p {
    border: 1px solid #ddd;
    padding: 10px;
}
.comment-box .media-body .media p {
    margin-bottom: 0;
}
.comment-box .media-heading {
    background-color: #f5f5f5;
    border: 1px solid #ddd;
    padding: 7px 10px;
    position: relative;
    margin-bottom: -1px;
}
.comment-box .media-heading:before {
    content: "";
    width: 12px;
    height: 12px;
    background-color: #f5f5f5;
    border: 1px solid #ddd;
    border-width: 1px 0 0 1px;
    -webkit-transform: rotate(-45deg);
    transform: rotate(-45deg);
    position: absolute;
    top: 10px;
    left: -6px;
}
</style>
<script>
	$(document).ready(function(){
		//게시물 수정
		$("#upBtn").click(function(){
			
			var title=$("#title").val();
			console.log($("#content").val());
			var content=$("#content").val();
			
			if(title == ""){
				alert("제목을 입력해주세요");
				document.boardForm.title.focus();
				return;
			}
			if(content == ""){
				alert("내용을 입력해주세요");
				document.boardForm.content.focus();
				return;
			}
			if(confirm("글을 수정하시겠습니까?")){
				document.boardForm.action="/bbsUpdate";
				document.boardForm.submit();
			}
		});
		//게시물 삭제
		$("#delBtn").click(function(){
			if(confirm("글을 삭제하시겠습니까?")){
				document.boardForm.action="/bbsDelete";
				document.boardForm.submit();
			}
		});
		//목록 페이지로 이동
		$("#listBtn").click(function(){
			document.boardForm.action="/listPage";
			document.boardForm.submit();
		});
		//댓글 등록
		$("#replyBtn").click(function(){
			var name=$("#name").val();
			var replyContent=$("#replyContent").val();
			bbsNo = $("#bbsNo").val();
			
			if(name == ""){
				alert("작성자 이름을 입력해주세요");
				document.replyForm.name.focus();
				return;
			}
			if(replyContent == ""){
				alert("댓글 내용을 입력해주세요");
				document.replyForm.replyContent.focus();
				return;
			}
			if(confirm("댓글을 등록 하시겠습니까?")){
				$.ajax({
					url:"/rplInsert",
					type:"POST",
					headers:{
						"Content-Type" : "application/json",
						"X-HTTP-Method-Override" : "POST"
					},
					dataType : 'text',
					//JSON.stringify : json 객체를 string 객체로 변환
					data : JSON.stringify({
						bbsNo : bbsNo,
						name : name,
						replyContent : replyContent
					}),
					success:function(result){
						console.log(result)
						if(result>0){
							alert("등록되었습니다");
						}

						getAllList(); //댓글 등록 후 댓글 목록 갱신 
						/* getReplies(); //댓글 목록 출력 함수  */
					},
					error:function(){
						console.log("에러");
					}
				})
			}
		});
	});
	
	//댓글 삭제
	function rplDel(replyNo){
		console.log("넘어옴"+replyNo);
		
		if(confirm("댓글을 삭제하시겠습니까?")){
			$.ajax({
				url:"/rplDelete",
				type:"POST",
				headers:{
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					replyNo : replyNo
				}),
				dataType : 'json',
				success:function(data){
					console.log(data)
					if(result>0){
						alert("삭제되었습니다");
						getAllList(); //댓글 삭제 후 댓글 목록 갱신
					}
				},
				error:function(){
					console.log("에러");
				}
			});
		}
	}
	
	//댓글 수정 버튼 클릭시
	function rplUp(replyNo){
		$("#up"+replyNo).css('display','none');
		$("#mod"+replyNo).css('display','block');
	}
	//댓글 수정
	function rplMod(replyNo){
		console.log("넘어옴"+replyNo);
		
		if(confirm("댓글을 수정하시겠습니까?")){
			$.ajax({
				url:"/rplUpdate",
				type:"POST",
				headers:{
					"Content-Type" : "application/json",
					"X-HTTP-Method-Override" : "POST"
				},
				dataType : 'text',
				data : JSON.stringify({
					replyNo : replyNo
				}),
				dataType : 'json',
				success:function(data){
					console.log(data)
					if(result>0){
						alert("삭제되었습니다");
						getAllList(); //댓글 삭제 후 댓글 목록 갱신
					}
				},
				error:function(){
					console.log("에러");
				}
			});
		}
	}
	
</script>
</head>
<body>
<!-- 헤더 -->
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<div class="container">
		<div class="row">
			<form name="boardForm" method="post">
			<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
				<colgroup>
					<col width="25%"/>
					<col width="*"/>
				</colgroup>
				<thead>
					<tr>
						<th colspan="3" style="background-color: #eeeeee; text-align :center;">BBS INFO</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>제목</td>
						<td><input type="text" style="width:100%" name="title" id="title" value="${bbsInfo.title}"/></td>
					</tr>
					<tr>
						<td>작성자</td>
						<td>${bbsInfo.name}</td>
					</tr>
					<tr>
						<td>작성일</td>
						<td>${bbsInfo.regDate}</td>
					</tr>
					<tr>
						<td>수정일</td>
						<td>${bbsInfo.modDate}</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${bbsInfo.viewCnt}</td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea style="resize: none; min-height: 200px;width:100%" name="content" id="content">${bbsInfo.content}</textarea></td>
					</tr>
				</tbody>
			</table>
			<input type="hidden" name="bbsNo" id="bbsNo" value="${bbsInfo.bbsNo}"/>
			<button type="button" id="listBtn" class="btn btn-primary btn-sm active">목록</button>
			<button type="button" id="upBtn" class="btn btn-primary btn-sm active">수정</button>
			<button type="button" id="delBtn" class="btn btn-primary btn-sm active">삭제</button>
			</form>
		</div>
	</div>
	<div class="container">
		<div class="well">
			<form name="replyForm" method="post" class="clearfix">
				<div class="col-md-12 form-group">
		            <label class="sr-only" for="name">Name</label>
		            <input type="text" class="form-control" id="name" placeholder="댓글 작성자">
		        </div>
		        <div class="col-md-12 form-group">
		            <label class="sr-only" for="email">Comment</label>
		            <textarea class="form-control" style="resize: none; height:100px;" id="replyContent" placeholder="댓글 내용"></textarea>
		        </div>
		        <div class="col-md-12 form-group text-right">
		            <button id="replyBtn" class="btn btn-info btn-sm active">댓글등록</button>
		        </div>
			</form>
		</div>
	<h3>===============댓글===============</h3>
		<c:forEach items="${rplInfo}" varStatus="status">
			<div class="media comment-box">
	            <div class="media-left">
	                <a href="#">
	                    <img class="img-responsive user-photo" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
	                </a>
	            </div>
	            <div class="media-body" id="up${rplInfo[status.index].replyNo}">
	                <h4 class="media-heading">${rplInfo[status.index].name}</h4>
	                <p id="rplContent">${rplInfo[status.index].replyContent }</p>
	            </div>
	            <div class="media-body" id="mod${rplInfo[status.index].replyNo}" style="display:none";>
	                <h4 class="media-heading">${rplInfo[status.index].name}</h4>
	                <textarea class="form-control" style="resize: none; height:100px;" id="replyUpdate" placeholder="댓글 내용">${rplInfo[status.index].replyContent }</textarea>

	            </div>
	            <div>
	            	<input type="hidden" id="replyNo" value="${rplInfo[status.index].replyNo}"/>
					<input type="button" id="upBtn" class="btn btn-success btn-sm active" value="수정" onclick="rplUp(${rplInfo[status.index].replyNo})">
					<input type="hidden" id="modBtn" class="btn btn-success btn-sm active" value="수정완료" onclick="rplMod(${rplInfo[status.index].replyNo})">
					<input type="button" class="btn btn-warning btn-sm active" value="삭제" onclick="rplDel(${rplInfo[status.index].replyNo})">
	            </div>
	       </div>
	  </c:forEach>
	</div>
</body>
</html>

