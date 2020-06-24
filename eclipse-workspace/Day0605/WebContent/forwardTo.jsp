<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String requestScope = (String)request.getAttribute("requestScope");
	String sessionScope = (String)session.getAttribute("sessionScope");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
ForwardTo.jsp<br>
requestScope = <%=requestScope %><br>
<%--
	%= : Expressiong Tag : out.print()와 동일한 역할
 --%>
 
sessionScope = <%=sessionScope %><br>
</body>
</html>