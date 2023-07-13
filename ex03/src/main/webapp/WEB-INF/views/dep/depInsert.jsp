<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서등록</title>
</head>
<body>
	<form action="depInsert" method="post">
	<!--action에 들어가는 값 controller의  @PostMapping("/depInsert") 안의 값 --> 
	
	<!--name값 : EmpVO 필드 값  --> 
		<div>
			<label>manager_id<input type="text" name="managerId"></label>
		</div>
		<div>
			<label>location_id<input type="text" name="locationId"></label>
		</div>
		<div>
			<label>department_name<input type="text" name="departmentName"></label>
		</div>
		<div>
			<label>department_id<input type="text" name="departmentId"></label>
		</div>
		<button type="submit">등록</button>
		<button type="button">목록</button>
		
	</form>
</body>
</html>