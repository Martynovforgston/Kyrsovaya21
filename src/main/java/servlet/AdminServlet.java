package servlet;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import core.settings.Property;
import core.settings.SettingsManager;

import core.login.Account;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
	
	private SettingsManager settings;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Если пользователь не авторизован, отправляем его на страницу авторизацию
		if (request.getSession().getAttribute("logged") == null || !(Boolean)request.getSession().getAttribute("logged")) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		// Если пользователь авторизован, но его аккаунт не найден или не имеет админские привилегии
		else if (request.getSession().getAttribute("account") == null || ((Account)(request.getSession().getAttribute("account"))).isAdmin() == false) {
			response.sendRedirect(request.getContextPath() + "/login");
			return;
		}
		
		settings = new SettingsManager();
		settings.load();
		// Пользователь нажал на кнопку сохранения файла
		if (request.getParameter("saveChange") != null) {
			//Проходимся по всем параметрам коэффициентов
			for(String parameter : request.getParameterMap().keySet()) {
				// Если в настройках есть такой параметр
			    if (settings.find(parameter) != null) {
			    	// Задаем в настройки параметр с новым значением
			    	settings.set(parameter, request.getParameter(parameter));
			    	// Обновляем данные для формы
			    	request.setAttribute(parameter, request.getParameter(parameter));
			    }
			}
			// Сохраняем в файл
			settings.save();
			request.setAttribute("messageSuccess", "Изменения успешно сохранены");
		}		
		request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
	}
	
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		// Если пользователь не авторизован, отправляем его на страницу авторизацию
		if (req.getSession().getAttribute("logged") == null || !(Boolean)req.getSession().getAttribute("logged")) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		// Если пользователь авторизован, но его аккаунт не найден или не имеет админские привилегии
		else if (req.getSession().getAttribute("account") == null || ((Account)(req.getSession().getAttribute("account"))).isAdmin() == false) {
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}
		settings = new SettingsManager();
	    //Загрузка данных на форму из файла, если файл не удастся создать, то загрузка по умолчанию
		settings.load();
	    //Проходимся по всем свойствам (коэффициентам) из настроек
		for (Property property: settings.getAll()) {
			// Обновляем данные для формы
			req.setAttribute(property.getName(), property.getValue());
		}
        req.getRequestDispatcher("WEB-INF/admin.jsp").forward(req, resp);
    }
}
