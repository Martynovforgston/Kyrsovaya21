package servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import core.calculator.*;
import core.settings.SettingsManager;
import core.utils.Helper;
import core.utils.PDF21;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
	
	SettingsManager settings;
	ICalculator calculator;
	List<Promo> promos;
	
	// Конструктор
	@Override
	public void init() throws ServletException {
		calculator = new Calculator21();
		promos = new ArrayList<Promo>();
		promos.add(new Promo21());
		promos.add(new SuperPromo());
		settings = new SettingsManager();
		settings.load();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Пользователь не авторизован
		if (request.getSession().getAttribute("logged") == null || !(Boolean)request.getSession().getAttribute("logged")) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// Пользователь нажал на кнопку расчета
		if (request.getParameter("calculate") != null){
			// Получаем данные из формы
			int count1leaf = Helper.parseInt(request.getParameter("1Leaf"));
			int count2leaf = Helper.parseInt(request.getParameter("2Leaf"));
			int count3leaf = Helper.parseInt(request.getParameter("3Leaf"));
			int countM2 = Helper.parseInt(request.getParameter("Floor"));
			
			boolean isOn = request.getParameter("on") != null;
			
			String promoValue = Helper.parseString(request.getParameter("promo"));
			String region = Helper.parseString(request.getParameter("district"));
			
			double rcoeff = Helper.getRegionCoeff(region, settings);
			double pcoeff = 1;
			
			// Проходимся по типам промокодов
			for(Promo promo: promos) {
				double coeff = promo.getCoeff(promoValue);
				// Если промокод дал скидку, сохраняем и выходим из цикла
				if (coeff < 1) {
					pcoeff = coeff;
					break;
				}
			}
			// Если коэфф не применился - промокод не верный, стираем с поля
				if (pcoeff == 1)
					promoValue = "";
			
			// Делаем расчет
			double result = calculator.calculate(rcoeff, pcoeff, count1leaf, count2leaf, count3leaf, countM2, isOn);
			// Обновляем форму
			request.setAttribute("district", region);
			request.setAttribute("count1leaf", count1leaf);
			request.setAttribute("count2leaf", count2leaf);
			request.setAttribute("count3leaf", count3leaf);
			request.setAttribute("countM2", countM2);
			request.setAttribute("on", isOn);
			request.setAttribute("promo", promoValue);
			request.setAttribute("result", (Math.round(result * 100)) / 100);
			// Выводим результат
			request.getRequestDispatcher("WEB-INF/calculator.jsp").forward(request, response);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Пользователь не авторизован
		if (request.getSession().getAttribute("logged") == null || !(Boolean)request.getSession().getAttribute("logged")) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		String action = Helper.parseString(request.getParameter("actionToDo"));
		Double result = Helper.parseDouble(request.getParameter("result"));
		
		// Пользователь выбрал пункт меню сохранения файла
		if (action.equals("saveToFile")) {
			// Передача файла, чтобы его можно было сохранить
			response.setContentType("application/pdf");
			// Вложение которое будет скачано  
			response.setHeader("Content-Disposition", "attachment; filename=check.pdf");
		// Обращаемся к ответу, который отдадим пользователю
	        try (OutputStream out = response.getOutputStream()) {
	          // Запись в ответ пользователя
			out.write(PDF21.create(
	            		Helper.parseString(request.getParameter("district")), 
	            		Helper.parseInt(request.getParameter("count1leaf")), 
	            		Helper.parseInt(request.getParameter("count2leaf")), 
	            		Helper.parseInt(request.getParameter("count3leaf")), 
	            		Helper.parseInt(request.getParameter("countM2")), 
	            		Helper.parseBool(request.getParameter("on")), 
	            		Helper.parseString(request.getParameter("promo")), 
	            		result));
			// Очистка буффера обмена
	            		response.flushBuffer();
	        } catch (Exception e) {
				System.out.println(e.getMessage());
			}
			//Т.К. дальнейшего перенаправляения не требуется, выходим из метода
			return;
		}
		
		request.getRequestDispatcher("WEB-INF/calculator.jsp").forward(request, response);
    }
}
