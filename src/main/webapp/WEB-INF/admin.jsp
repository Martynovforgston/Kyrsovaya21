<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>Админ-панель</title>
	<link rel="stylesheet" href="css/style.css">
</head>
<body>
<script type="text/javascript">
function openWindow() {
	myWindow=open("aboutProgram.html", "О программе", "width=450px, height=400px, status=no; tollbar=no, menubar=no, scrollbar=no");
}
</script> 
<div class="wrapper">
  <header class="header">
  <div class=navbar>
	<div class="dropdown">
		<button class="dropbtn">Справка</button>
			<div class="dropdown-content">
				<a href="javascript:{openWindow()}">О программе</a>
			</div>
	</div>
		<div class="dropdown">
		<button class="dropbtn">Аккаунт</button>
			<div class="dropdown-content">
				<a href="${pageContext.request.contextPath}/login">Выйти</a>
			</div>
	</div>
	</header><!-- .header-->
  
  <main class="content">
  <form action = "${pageContext.request.contextPath}/admin" method="post" id="Admin">
  <table border=0 cellpadding=5% >
		<tr>
			<td>Район города</td>
			<td>Коэффициент</td>
		</tr>
		<tr>
			<td><label for="Kalininsky">Калининский</label></td>
			<td><input type="number" id="Kalininsky" name="Kalininsky" min="1" max="3" step="0.1" value="${Kalininsky}"> </td>
		</tr>
		<tr>
			<td><label for="Kirovsky">Кировский</label></td>
			<td><input type="number" id="Kirovsky" name="Kirovsky" min="1" max="3" step="0.1" value="${Kirovsky}"> </td>
		</tr>
		<tr>
			<td><label for="Octobersky">Октябрьский</label></td>
			<td><input type="number" id="Octobersky" name="Octobersky" min="1" max="3" step="0.1" value="${Octobersky}"> </td>
		</tr>

		<tr>
			<td><label for="Leninsky">Ленинский</label></td>
			<td><input type="number" id="Leninsky" name="Leninsky" min="1" max="3" step="0.1" value="${Leninsky}"> </td>
		</tr>
		<tr>
			<td><label for="Ordzhonikidzevskiy">Орджоникидзевский</label></td>
			<td><input type="number" id="Ordzhonikidzevskiy" name="Ordzhonikidzevskiy" min="1" max="3" step="0.1" value="${Ordzhonikidzevskiy}"> </td>
		</tr>

		<tr>
			<td><label for="Demsky">Демский</label></td>
			<td><input type="number" id="Demsky" name="Demsky" min="1" max="3" step="0.1" value="${Demsky}"> </td>
		</tr>
		<tr>
			<td><label for="Sovetsky">Советский</label></td>
			<td><input type="number" id="Sovetsky" name="Sovetsky" min="1" max="3" step="0.1" value="${Sovetsky}"> </td>
		</tr>

		<tr>
		<td colspan=2>
			<button type="submit" name="saveChange" class="btnAdmin"> Сохранить изменения</button>
		</td>
		</tr>
		
	</table>
</form>

<p style='color: green;'>${messageSuccess}</p> 
	</main><!-- .content -->
</div><!-- .wrapper -->
<footer class="footer">
	<img src="image/logo.jpg" id=section-to-print class="logo"> 
	<p class=pCalc>Компания ООО "ВАРИАНТ 21" представляет "Калькулятор клининговых услуг для квартир"
</div><!-- .footer -->
</body>
</html>
