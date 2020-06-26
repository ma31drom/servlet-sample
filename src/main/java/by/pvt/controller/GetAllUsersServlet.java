package by.pvt.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import by.pvt.service.UserRepository;

@WebServlet(urlPatterns = "/users/all")
public class GetAllUsersServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		try {
			resp.getWriter()
			.write(new ObjectMapper()
					.writeValueAsString(UserRepository.getInstance().getAllUsers()));
		} catch (SQLException e) {
			throw new IOException(e);
		}
	}

}
