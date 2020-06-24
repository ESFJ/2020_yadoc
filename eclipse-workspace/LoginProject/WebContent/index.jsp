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
	<%
		if(loginMember == null){
			//login이 안된 상태 -> 로그인 페이지로 넘어가도록 함
	%>
		<a href = "loginForm.jsp">로그인</a><br>
		<a href = "memberRegistForm.jsp">회원가입</a>
	<%
		} else{
			//login된 상태 -> 로그아웃 페이지로 넘어가도록 함
	%>
		<a href = "logout.me">로그아웃</a>
	<% 
		}
	%>
</body>
</html>