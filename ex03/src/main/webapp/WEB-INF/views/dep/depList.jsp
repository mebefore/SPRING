<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> <!-- 숫자, 날짜, 시간을 formatting할 수 있게 함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<style type="text/css">
	table, th, td {
		border : 1px solid black;
	}
</style>
</head>
<body>
	<button type="button" onclick="location.href='depInsert'">등록</button>
	<table>
		<thead>
			<tr>
				<th>manager_id</th>
				<th>location_id</th>
				<th>department_name</th>
				<th>department_id</th>
				<th>Delete</th>	
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${depList }" var="dep">
				<tr onclick="location.href='depInfo?departmentId=${dep.departmentId}'">
					<td>${dep.departmentId }</td> 
					<td>${dep.managerId }</td>
					<td>${dep.locationId }</td>
					<td>${dep.departmentName }</td>
					<td><button type = "button">삭제</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script>
		printMessage(`${result}`); //redirect attrinute로 넘어오는 값 = result
	
		function printMessage(msg){
			if(msg == null || msg == '') return;
			alert(msg);
		}
		
		$('button:contains("삭제")').on('click', ajaxDeleteDep);
		
		function ajaxDeleteDep(e){
			let depId = e.currentTarget.closest('tr').firstElementChild.textContent;
			
			$.ajax({
				url : 'depDelete',
				type : 'post',
				data : { id : depId}
			})
			
			.done( data =>{
				if(data == "success"){
					let btn = e.currentTarget;
					$(btn).closest('tr').remove();
				}else{
					alert('삭제되지 않았습니다.');
				}
			})
			.fail( reject => console.log(reject));
			
			//e.stopPropagation(); //event 전파를 막을 때 쓰는 메소드
			return false;
		}
	</script>
</body>
</html>