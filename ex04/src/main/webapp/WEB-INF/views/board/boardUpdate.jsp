<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="updateForm" >
<h1>수정 페이지</h1>
		<table>
			<tr>
				<th>글번호</th>
				<td><input type="text" name="bno" value="${boardInfo.bno }" readonly></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" value="${boardInfo.title }"></td>
			</tr>
			<tr>
				<th>작성자</th>
				<td><input type="text" name="writer" value="${boardInfo.writer }"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents" >${boardInfo.contents }</textarea></td>
			</tr>
			<tr>
				<td>첨부이미지</td>
				<th><input type="text" name="image" value="${boardInfo.image }"></th>
			</tr>
			<tr>
				<td>수정일자</td>
				<th><input type="date" name="updatedate" 
						value="<fmt:formatDate value="${boardInfo.updatedate }" pattern="yyyy-MM-dd"/>">
				</th>
			</tr>
			
		</table>
			<button type="submit">수정</button>
			<button type="button"
					onclick="location.href='boardInfo?bno=${boardInfo.bno }'">목록</button>
	</form>
	<script>
		$('form').on('submit', function(e){
			
			let objData = serializeObject();
			
			$.ajax({
				url : 'boardUpdate',
				method : 'post',
				data : objData
			})
			.done(data => { 
				if(data.result){
					let message = '수정되었습니다.\n사원번호 : ' + data.boardInfo.bno;
					alert(message);
				}else{
					alert('수정되지 않았습니다.\n정보를 확인해주세요.')
				}
			})
			.fail(reject => console.log(reject));
			
			return false;
		});
		
		function serializeObject(){
			let formData = $('form').serializeArray();
			//form 태그에 걸어줘야지만 시리얼라이즈 작동됨 (?)
			
			let formObject = {};
			$.each(formData, function(idx, obj){
				let field = obj.name;
				let val = obj.value;
				
				formObject[field] = val;
				
			});
			
			return formObject;
		}
	</script>
</body>
</html>