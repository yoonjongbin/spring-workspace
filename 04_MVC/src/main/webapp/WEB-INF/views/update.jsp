<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="updateMember" method="post">
		아이디 : <input type="text" name="id" value="${vo.id}" readonly> <br>
		비밀번호 : <input type="password" name="pwd" value="${vo.pwd}"> <br>
		이름 : <input type="text" name="name" value="${vo.name}"> <br>
		주소 : <input type="text" name="addr" value="${vo.addr}"> <br>
		<input type="submit" value="전송">
	</form>
</body>
</html>