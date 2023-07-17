<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세내용</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body><!--form태그는 json으로 못보냄. path나 json사용해야됨 -->
	<form><!-- 경로 -->
	<div>	<!--  뿌려주기만해서 name속성은 필요없음 ->name: java에 쓰임 -->
	<!--모델에 들어있는 데이터=$ empInfo.  -->
		<label>번호 :<input type="text" name="bno" value="${boardInfo.bno }" readonly></label> 
	</div>
	<div>
		<label>제목: <input type="text" name="title" value="${boardInfo.title }"></label>
	</div>
	<div>
		<label>작성자: <input type="text" name="writer" value="${boardInfo.writer}"></label>
	</div>
	<div>
		<label>내용: <textarea row="3"
								cols="2"
								style="width : 100px;"
								readonly>${boardInfo.contents }</textarea>
		</label>
	</div>
	<div>
		<label>첨부이미지: 
		<c:choose>
			<c:when test="${not empty boardInfo.image }"> <!--파일 존재 : 파일 보여줌, 파일 x : 파일 안 보여줌  -->
			<img src='<c:url value="/resources/${boardInfo.image }"/>'>
			</c:when>
			<c:otherwise>
				파일없음
			</c:otherwise>
		</c:choose>
		</label>
	</div>
	
	<div>
		<label>작성일: <fmt:formatDate value="${boardInfo.regdate }" pattern="yyyy/MM/dd"/></label>
	</div>

		<button type="button" onclick="location.href='boardList'">목록</button>
	</form>
	
	<button type="button" onclick="location.href='boardUpdate?bno=${boardInfo.bno }'">수정</button>	
	<button type="button" onclick="location.href='boardDelete?bno=${boardInfo.bno }'">삭제</button>	

</body>
</html>