<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<title>게시글작성</title>
<script>
	$(document).ready(function(){
		$("#insertBtn").click(function(){
			
			var title=$("#title").val();
			var content=$("#content").val();
			var name=$("#name").val();
			
			if(title == ""){
				alert("제목을 입력해주세요");
				document.boardInsert.title.focus();
			}
			if(name == ""){
				alert("작성자 이름을 입력해주세요");
				document.boardInsert.name.focus();
			}
			
			if(content == ""){
				alert("내용을 입력해주세요");
				document.boardInsert.content.focus();
			}
			if(confirm("글을 등록하시겠습니까?")){
				document.boardInsert.action="/bbsInsert";
				document.boardInsert.submit();
			}
		});
	});
</script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />
	<div class="container">
		<div class="row">
			<form name="boardInsert" method="post">
				<table class="table table-striped" style="text-align:center; border:1px solid #dddddd">
					<colgroup>
						<col width="25%"/>
						<col width="*"/>
					</colgroup>
					<thead>
						<tr>
							<th colspan="2" style="background-color : #eeeeee; text-align:center;"><h4>BBS Write</h4></th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>제목</td>
							<td><input type="text" style="width:95%;" name="title" id="title"/></td>
						</tr>
						<tr>
							<td>작성자</td>
							<td><input type="text" style="width:95%;" name="name" id="name"/></td>
						</tr>
						<tr>
							<td>내용</td>
							<td><textarea style="width:95%; height:300px;resize: none;" name="content" id="content"></textarea></td>
						</tr>
					</tbody>
				</table>
			<button id="insertBtn" class="btn btn-primary pull-right">등록</button>
			</form>
		</div>
	</div>
</body>
</html>