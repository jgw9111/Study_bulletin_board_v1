<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
.center {
  text-align: center;
}
.pagination {
  display: inline-block;
}
.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #ddd;
  margin: 0 4px;
}
.pagination a.active {
  background-color: #4CAF50;
  color: white;
  border: 1px solid #4CAF50;
}
.pagination a:hover:not(.active) {
    background-color: #ddd;
}
</style>
</head>
<body>

	<div>
		<h1>자유게시판</h1>
	</div>
	<div style="width:650px;" align="right">
		<a href="./freeBoardInsert.ino">글쓰기</a>
	</div>
	<hr style="width: 600px">
	
	<c:forEach items="${freeBoardList }" var="dto">
			<div style="width: 50px; float: left;">${dto.num }</div>	
			<div style="width: 300px; float: left;"><a href="./freeBoardDetail.ino?num=${dto.num }">${dto.title }</a></div>
			<div style="width: 150px; float: left;">${dto.name }</div>
			<div style="width: 150px; float: left;">${dto.regdate }</div> 
		<hr style="width: 600px">
	</c:forEach>
	
<!-- 페이지네이션 --> 
	<div style="height: 50px"></div>
	<div class="center">
		<div class="pagination">
			<c:if test="${pageMaker.prev}">
			  <li class="paginate_button previous">
			 	<a href="${pageMaker.startPage-1}" >PREV</a>
			  </li>
			</c:if>
			 <c:forEach var="num" begin="${pageMaker.startPage }" end="${pageMaker.endPage }" >
			 	<li class="paginate_button ${pageMaker.pdto.pageNum == num ? "active":""} ">
				 	<a href="${num}">${num}</a>
			 	</li>
		 	 </c:forEach>
		  <c:if test="${pageMaker.next}">
		  	<li class="paginate_button next">
			  <a href="${pageMaker.endPage+1}" >NEXT</a>
		  	</li>
		  </c:if>
		</div>
	</div>
	<form id='actionForm' action="/mavenBoard/main.ino">
				<input type='hidden' name='pageNum' value='${pageMaker.pdto.pageNum}'>
				<input type='hidden' name='amount' value='${pageMaker.pdto.amount}'>
	</form>
	
<script type="text/javascript">
	var actionForm = $("#actionForm");
	$('.paginate_button a').click(function(e){
		e.preventDefault();
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
</script>
</body>
</html>
