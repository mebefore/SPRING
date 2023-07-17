<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body>
<table align="center" border="1px black">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
		<button type="button" onclick="location.href='boardInsert'">등록</button>
	<c:forEach items="${boardList }" var="board">
				<tr onclick="location.href='boardInfo?bno=${board.bno}'">
					<td>${board.bno }</td> 
					<td>${board.title }</td>
					<td>${board.writer}</td>
					<!--날짜 데이터 변환을 위해 fmt쓴다, 상단에 taglib fmt 등록  -->
					<td>
						<fmt:formatDate value="${board.regdate }" pattern="yyyy년MM월dd일"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>