<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
</head>
<body>
<form name="insertForm" action="boardInsert" method="post">
		<table>

			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea name="contents"></textarea></td>
			</tr>
			<tr>
				<td>작성자</td>
				<th><input type="text" name="writer"></th>
			</tr>
			<tr>
				<td>첨부이미지</td>
				<th><input type="text" name="image"></th>
			</tr>
			<tr>
				<td>등록일자</td>
				<th><input type="date" name="regdate"></th>
			</tr>
			
		</table>
			<button type="submit">등록</button>
			<button type="button">목록</button>
	</form>

	<script>
		document.querySelector('form[name="insertForm"]')
				.addEventListener('submit', function(e){
					e.preventDefault();

					let title = document.getElementsByName('title')[0];			
					let writer = document.getElementsByName('writer')[0];		

					if(title.value == ''){
						alert('제목이 입력되지 않았습니다.');
						title.focus(); //title로 포커스 이동하게 하는 거 - 이벤트 강제 호출 (메소드 방식)
						return;
					}

					if(writer.value == ''){
						alert('작성자가 입력되지 않았습니다.');
						writer.focus();
						return;
					}
				
				insertForm.submit();
			});			
	</script>
</body>
</html>