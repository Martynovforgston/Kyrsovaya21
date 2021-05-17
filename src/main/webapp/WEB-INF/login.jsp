<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Авторизация</title>
	<link rel="stylesheet" href="css/styleLogin.css">
</head>
<body>
<div class="wrapper">
  <header class="header">
<img src="image/logo.jpg" id=section-to-print class="logo"> 
	</header><!-- .header-->
  
  <main class="contentLogin">
  <form action="${pageContext.request.contextPath}/login" method="post" class="formLogin">
		
			<label for="login">Логин</label><br> <input type="text"name="login" id="login" value="${login}" placeholder="Введите логин">
			<br> <label for="password">Пароль</label><br> <input type="password" name="password" id="password" value="${password}" placeholder="Введите пароль"> <br>
			<button type="submit" name="sign" value="Sign" class="btn">Войти</button>
		
	</form>
	  	<p style='color: red;'>${message}</p> 
		
	</main><!-- .content -->

</div><!-- .wrapper -->
</body>
</html>
