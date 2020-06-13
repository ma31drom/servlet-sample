package by.pvt.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.pvt.models.UserInfo;
import by.pvt.service.NewsService;
import by.pvt.service.UserService;

@WebServlet(urlPatterns = "/in")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		req.setAttribute("currentDate", simpleDateFormat.format(new Date()));

		UserInfo attribute = (UserInfo) req.getSession().getAttribute("currentUser");

		if (attribute != null) {
			req.setAttribute("news", NewsService.getInstance().getNews(attribute.getUsername()));
		}

		setLocale(req);

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
		
	}

	private void setLocale(HttpServletRequest req) {
		
		String header = req.getHeader("accept-language");

		if (header.contains("ru-RU")) {
			req.getSession().setAttribute("locale", "ru_RU");
		} else {
			req.getSession().setAttribute("locale", "us_EN");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		UserInfo userByPassAndName = UserService.getInstance().getUserByPassAndName(req.getParameter("password"),
				req.getParameter("username"));
		if (userByPassAndName != null) {
			req.getSession().setAttribute("loggedUser", userByPassAndName.toString());
			req.getSession().setAttribute("currentUser", userByPassAndName);
			req.setAttribute("news", NewsService.getInstance().getNews(userByPassAndName.getUsername()));
		}

		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
