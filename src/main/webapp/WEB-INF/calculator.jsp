<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Калькулятор клининговых услуг для квартир</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>

<script type="text/javascript">
function openWindow() {
	myWindow=open("aboutProgram.html", "О программе", "width=450px, height=400px, status=no; tollbar=no, menubar=no, scrollbar=no");
}
</script> 

<div class="navbar">
	<div class="logo">
		<img src="image/logo.jpg" width=50em height=50em id=section-to-print>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Файл</button>
			<div class="dropdown-content">
				<a href="calculator?actionToDo=saveToFile&result=${result}&count1leaf=${count1leaf}&count2leaf=${count2leaf}&count3leaf=${count3leaf}&countM2=${countM2}&promo=${promo}&isOn=${isOn}">Сохранить в файл</a>
				<a href="javascript:print()">Печать файла</a>
			</div>
	</div>
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
</div> 
	
	<p style='color: red;'>${message}</p>
	
	<div class="container"> 
		<form action="${pageContext.request.contextPath}/calculator" method="post" id="Calculator">
			<label for="district" id="section-to-print"> Район города </label> 
			<select name="district" form="Calculator" class="selDis" required id="section-to-print">
				<option value="Kalininsky">Калининский</option>
				<option value="Kirovsky">Кировский</option>
				<option value="Octobersky">Октябрьский</option>
				<option value="Leninsky">Ленинский</option>
				<option value="Ordzhonikidzevskiy">Орджоникидзевский</option>
				<option value="Demsky">Демский</option>
				<option value="Sovetsky">Советский</option>
			</select> <br>
			<table border="0" cellpadding="5%">
				<tr>
					<td><label for="1Leaf" id="section-to-print">Одностворчатых окон</label></td>
					<td><label for="2Leaf" id="section-to-print">Двустворчатых окон</label></td>
					<td><label for="3Leaf" id="section-to-print">Трехстворчатых окон</label></td>
				</tr>
				<tr>
					<td><input type="number" id="section-to-print" name="1Leaf" min="0" max="100" value="${count1leaf}"></td>
					<td><input type="number" id="section-to-print" name="2Leaf" min="0" max="100" value="${count2leaf}"></td>
					<td><input type="number" id="section-to-print" name="3Leaf" min="0" max="100" value="${count3leaf}"></td>
				</tr>
				<tr>
					<td colspan="3"><label for="Floor" id="section-to-print">Количество кв м пола </label> 
					<input type="number" id="section-to-print" name="Floor" min="0" max="200" value="${countM2}"></td>
				</tr>
			</table>
			
			<input type="checkbox" name="on" value="${isOn}" id="section-to-print"> 
			<label for="isOn" id="section-to-print"> Включить услугу мытья санузла<br> </label>
			<label for="promo" id="section-to-print">Промокод </label> 
			<input type="text" name="promo" id="section-to-print" value="${promo}" placeholder="Введите промокод"> <br> 
			<label for="promo" id="section-to-print">Стоимость</label>

			<input type="text" name="result" id="section-to-print" value="${result}" disabled> <br>

			<button type="submit" name="calculate" value="Calc" class="btn">Рассчитать</button> <br>
			
		</form>
	</div>
</div>
</body>
</html>
