<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 사원 조회</title>
</head>
<body>
	<script>
		document.addEventListener('DOMContentLoaded', function(e){ //안에서 함수 정의 x
			document.getElementById('cntPerPage')
					.addEventListener('change', changeHandler);
			
		});
		
		function changeHandler(e){
			let selected = document.getElementById('cntPerPage').value;
			location.href = 'empList?nowPage=${paging.nowPage}&cntPerPage=' + selected;
			
		}
	</script>
	<div>
		<div>
			<select id="cntPerPage">
				<option value="5"
					<c:if test="${paging.cntPerPage == 5 }">selected</c:if>>5줄 보기</option>					
				<option value="10"
					<c:if test="${paging.cntPerPage == 10 }">selected</c:if>>10줄 보기</option>
				<option value="15"
					<c:if test="${paging.cntPerPage == 15 }">selected</c:if>>15줄 보기</option>
				<option value="20"
					<c:if test="${paging.cntPerPage ==20 }">selected</c:if>>20줄 보기</option>
			
			</select>
		</div>
		<table border="1">
			<thead>
				<tr>
					<th>employee_id</th>
					<th>first_name</th>
					<th>last_name</th>
					<th>email</th>
					<th>job_id</th>			
				</tr>
			</thead>
			
			<tbody>
				<c:forEach items="${empList }" var="empInfo">
					<tr>
						<td>${empInfo.employeeId }</td>
						<td>${empInfo.firstName }</td>
						<td>${empInfo.lastName }</td>
						<td>${empInfo.email }</td>
						<td>${empInfo.jobId }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div style="text-align:center;">
			<!-- 이전 -->
			<c:if test="${paging.startPage != 1}"> <!-- 페이지가 1이 아닌 경우에만 이전 이라는 게 존재한다ㅡ 항상 태그 존재하는 게 아니라 특별한 조건 충족될 때 태그 생성된다 -->
				<a href="empList?nowPage=${paging.startPage -1 }&cntPerPage=${paging.cntPerPage}">&lt;</a>
			</c:if> 
			
			<!-- view 안에 보여지는 페이지 수 : 1 | 2| 3| 4 | 5 -->
			<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p"> <!--p=현재페이지 가르키는 것 (ex.6페이지, 7페이지) -->
				<c:choose>
					<c:when test="${p eq paigng.nowPage}"> <!-- 현재페이지는 재호출/링크 걸 필요 없다 -->
						<b>${p}</b> <!-- 그래서 굵게 글씨 처리만  -->
					</c:when>
					<c:otherwise>
						<a href="empList?nowPage=${p}&cntPerPage=${paging.cntPerPage}">${p}</a> <!-- 현재 페이지가 아닌 다른 페이지들은 링크를 걸어준다 -->
					</c:otherwise>
				</c:choose>
			</c:forEach>
			
			<!-- 다음 -->
			<c:if test="${paging.endPage != paging.lastPage}"> <!-- 페이지가 마지막 페이가 아닌 경우에만 다음이라는 게 존재한다ㅡ 항상 태그 존재하는 게 아니라 특별한 조건 충족될 때 태그 생성된다 -->
				<a href="empList?nowPage=${paging.endPage +1 }&cntPerPage=${paging.cntPerPage}">&gt;</a> <!-- 마지막 페이지가 아니라면 다음 링크 누르면 페이지가 +1이 된다 -->
			</c:if>
		</div>
	</div>
	
</body>
</html>