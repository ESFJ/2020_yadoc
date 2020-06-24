<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO loginMember = (MemberVO)session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>로그인된 사용자 정보</h1>
	id = <%=loginMember.getId() %><br>
	name = <%=loginMember.getName() %><br>
	email = <%=loginMember.getEmail() %><br>
	passwd = <%=loginMember.getPasswd() %><br>
</body>
</html>