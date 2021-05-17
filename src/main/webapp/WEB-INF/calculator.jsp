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
<div class="wrapper">
  <header class="header">
	 <div class=navbar>
	 <div class="dropdown">
		<button class="dropbtn">Файл</button>
				<div class="dropdown-content">
					<a href="calculator?actionToDo=saveToFile&result=${result}&count1leaf=${count1leaf}&count2leaf=${count2leaf}&count3leaf=${count3leaf}&countM2=${countM2}&promo=${promo}&on=${on}">Сохранить в файл</a>
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
		</header><!-- .header-->

	  <main class="content">
		<form action="${pageContext.request.contextPath}/calculator" method="post" id="Calculator" autocomplete="off">
				<label for="district" id="section-to-print"> Район города </label> 
	      <div class=select>
				<select name="district" form="Calculator" class="selectDis" required id="section-to-print">
					<option value="Kalininsky" ${district=="Kalininsky"?"selected":""}>Калининский</option>
					<option value="Kirovsky" ${district=="Kirovsky"?"selected":""}>Кировский</option>
					<option value="Octobersky" ${district=="Octobersky"?"selected":""}>Октябрьский</option>
					<option value="Leninsky" ${district=="Leninsky"?"selected":""}>Ленинский</option>
					<option value="Ordzhonikidzevskiy" ${district=="Ordzhonikidzevskiy"?"selected":""}>Орджоникидзевский</option>
					<option value="Demsky" ${district=="Demsky"?"selected":""}>Демский</option>
					<option value="Sovetsky" ${district=="Sovetsky"?"selected":""}>Советский</option>
				</select>
	      </div>
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

				<input type="checkbox" name="on" value="${isOn}" id="section-to-print" ${on?"checked":""}> 
				<label for="isOn" id="section-to-print"> Включить услугу мытья санузла<br> </label>
				<label for="promo" id="section-to-print">Промокод&nbsp;</label> 
				<input type="text" name="promo" id="section-to-print" value="${promo}" placeholder="Введите промокод"> <br> 
				<label for="promo" id="section-to-print">Стоимость</label>

				<input type="text" name="result" id="section-to-print" value="${result}" disabled> <br>

			<button type="submit" name="calculate" value="Calc" class="btn">Рассчитать</button> <br>

			</form>
	</main><!-- .content -->
</div><!-- .wrapper -->

<footer class="footer">
	<img src="logo.jpg" id=section-to-print class="logo"> 
	<p class=pCalc>Компания ООО "ВАРИАНТ 21" представляет "Калькулятор клининговых услуг для квартир"
</div><!-- .footer -->
</body>
</html>
