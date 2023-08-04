<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<sec:csrfMetaTags/>
<title>Insert title here</title>
</head>
<body>
	<h1> 톱 페이지입니다.</h1>
	<ul>
		 <li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
		 
		 <!-- 관리자일 경우에만 페이지 사용 가능 -->
		 <sec:authorize access="hasRole('ROLE_ADMIN')">
		 	<li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
		 </sec:authorize>
	</ul>
	
	<!-- 로그아웃은 로그인 한 사람만 보이게/ 접근할 때만 태그 보이게  sec:authorize
		access 안의 값 :현재 로그인한 사용자가 익명이 아닌 경우 true 반환 (인증만 되어 있으면 접근 허용)-->
	<sec:authorize access="isAuthenticated()">
		<form action="logout" method="post">
			<sec:csrfInput/>
		 	<button>로그아웃</button>
		</form>
	</sec:authorize>
	<!--input 태그로 숨겨놓기-->
	<input type="hidden" name="csrf_name" value="${_csrf.parameterName}">
	<input type="hidden" name="csrf_value" value="${_csrf.token}">
</body>
</html>