<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>부서조회</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
</head>
<body><!--form태그는 json으로 못보냄. path나 json사용해야됨 -->
	<form><!-- 경로 -->
	<div>	<!--  뿌려주기만해서 name속성은 필요없음 ->name: java에 쓰임 -->
	<!--모델에 들어있는 데이터=$ empInfo.  -->
		<label>팀장번호 :<input type="number" name="managerId" value="${depInfo.managerId }" readonly></label> 
	</div>
	<div>
		<label>지역번호: <input type="text" name="locationId" value="${depInfo.locationId }"></label>
	</div>
	<div>
		<label>부서이름: <input type="text" name="departmentName" value="${depInfo.departmentName }"></label>
	</div>
	<div>
		<label>부서번호: <input type="text" name="departmentId" value="${depInfo.departmentId }"></label>
	</div>

		<button type="submit">수정</button>
		<button type="button" onclick="location.href='depList'">목록</button>
	</form>
	
	<script>
		// 1) form태그의 submit 이벤트 동작하면 안됨 stop
		$('form').on('submit',ajaxUpdateDep);
		
		// 2) form 태그 내의 정보를 가져옴
		function serializeObject(){
			let formData=$('form').serializeArray();// 객체 배열: 객체 하나 -> input태그 하나
			
			let objectData={};//변수선언
			$.each(formData,function(idx,obj){
				objectData[obj.name]=obj.value;
			});
			return objectData;
		}
		
		// 3) ajax를 통해 통신을요청해야됨
		function ajaxUpdateDep(e){
			e.preventDefault();
			
			
			let obj=serializeObject();
			
			
			$.ajax({				
			url: 'depUpdate',
			type:'post',
			contentType:'application/json',
			data:JSON.stringify(obj)
		})
		.done(data => {
			if(data != null && data['결과'] == 'success'){
				alert('부서번호 : ' + data['부서번호'] + '의 정보가 수정되었습니다.');
				
			}else{
				alert('해당 사원의 정보가 정상적으로 수정되지 않았습니다.');
			}
		})
		.fail(reject =>console.log(reject));
	};

	</script>
</body>
</html>