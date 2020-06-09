package by.pvt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/in")
public class HelloWorldServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		UserInfo userByPassAndName = UserService.getInstance().getUserByPassAndName(req.getParameter("password"),
				req.getParameter("username"));
		if (userByPassAndName != null) {
			req.getSession().setAttribute("loggedUser", userByPassAndName);
		}
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
}
