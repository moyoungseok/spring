<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<script
  src="https://code.jquery.com/jquery-2.2.4.js"
  integrity="sha256-iT6Q9iMJYuQiMWNd9lDyBUStIq/8PuOW33aOqmvFpqI="
  crossorigin="anonymous"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<title>bbsList</title>
</head>
<body>
<!-- 헤더 내비 -->
<jsp:include page="/WEB-INF/views/header.jsp" flush="false" />

<div class="container">
	<h3 class="text-center"><b>BBS LIST  </b></h3>
	<table class="table table-bordered table-hover">
		<colgroup>
			<col width="10%"/>
			<col width="*"/>
			<col width="10%"/>
			<col width="10%"/>
		</colgroup>
		<thead class="table">
			<tr >
				<th class="text-center">등록자</th>
				<th class="text-center">제목</th>
				<th class="text-center">등록년월일시</th>
				<th class="text-center">수정년월일시</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${bbsList}" var="list" varStatus="status">
				<tr>
					<td class="text-center">${bbsList[status.index].name }</td>
					<td><a href="/bbsInfo?bbsNo=${bbsList[status.index].bbsNo}">${bbsList[status.index].title }</a></td>
					<td>${bbsList[status.index].regDate }</td>
					<td>${bbsList[status.index].modDate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<button id="insertBtn" class="btn btn-primary btn-sm active pull-right" onclick="location.href='writeBBS'">글작성</button>
	<!-- 페이징 -->
	<div class="text-center">
		<ul class="pagination">
			<c:if test="${page.prev}">
				<li><a href="listPage?pageIndex=${page.startPage-1 }">&laquo;</a></li>
			</c:if>
			<c:forEach begin="${page.startPage}" end="${page.endPage}" var="idx">
				<li
					<c:out value="${page.base.pageIndex == idx? 'class=active':''}"/>>
					<a href="listPage?pageIndex=${idx}">${idx}</a>
				</li>
			</c:forEach>
			<c:if test="${page.next && page.endPage >0}">
				<li><a href="listPage?pageIndex=${page.endPage+1}">&raquo;</a></li>
			</c:if>
		</ul>
	</div>
</div>
</body>
</html>
