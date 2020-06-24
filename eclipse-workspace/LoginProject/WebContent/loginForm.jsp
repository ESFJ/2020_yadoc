<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	if(id == null){
		id = "";
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#loginFormArea{
		width : 300px;
		height : 200px;
		border : 3px double green;
		margin : auto;
		text-align: center;
	}
	h1{
		text-align: center;
		border-bottom: 1px solid blue;
	}
	input[type="submit"]{
		margin-top: 10px;
	}
	fieldset {
		height : 150px;
		text-align: center;
		border : none;
	}
}
</style>
</head>
<body>
	<section id = "loginFormArea">
		<h1>로그인</h1>
		<form action="login.me" method = "POST">
		<fieldset>
			<label for = "id">아이디 : </label>
			<!-- 새로 등록한 회원의 id값은 보여주면서 로그인 -->
			<input type = "text" name = "id" id = "id" value = "<%=id %>"><br>
			
			<label for = "passwd">비밀번호 : </label>
			<input type = "password" name = "passwd" id = "passwd"><br>
			
			<label for = "cookieUse">쿠키사용 : </label>
			<input type = "checkbox" name = "cookieUse" id = "cookieUse"><br>
			
			<input type = "submit" value = "로그인"><br>

		</fieldset> <!-- 여러가지 필드를 묶어서 필드셋으로 만들어줌 화면에 묶여서 나옴  묶어서 스타일 지정 가능 -->
		</form>
	</section>
</body>
</html>




