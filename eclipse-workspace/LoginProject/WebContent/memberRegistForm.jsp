<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1>회원가입</h1>
		<form action="memberRegist.me" method = "POST">
		<fieldset>
			<label for = "id">아이디 : </label>
			<input type = "text" name = "id" id = "id"><br>
			
			<label for = "passwd">비밀번호 : </label>
			<input type = "password" name = "passwd" id = "passwd"><br>
			
			<label for = "name">이름: </label>
			<input type = "text" name = "name" id = "name"><br>
			
			<label for = "email">이메일 : </label>
			<input type = "text" name = "email" id = "email"><br>
			
			<input type = "submit" value = "회원가입"><br>

		</fieldset> <!-- 여러가지 필드를 묶어서 필드셋으로 만들어줌 화면에 묶여서 나옴  묶어서 스타일 지정 가능 -->
		</form>
	</section>
</body>
</html>




