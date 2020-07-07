package by.pvt.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import by.pvt.models.UserInfo;
import by.pvt.service.UserRepository;

@WebServlet(urlPatterns = "/users")
public class UserByIdOperationsServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String parameter = req.getParameter("id");
		Long valueOf = Long.valueOf(parameter);
		resp.getWriter()
				.write(new ObjectMapper().writeValueAsString(UserRepository.getInstance().getUserById(valueOf)));
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String parameter = req.getParameter("id");
		Long valueOf = Long.valueOf(parameter);
		boolean deleteUserById = UserRepository.getInstance().deleteUserById(valueOf);

		resp.getWriter().write("User was deleted of not? Result of operation is:" + deleteUserById);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ObjectMapper objectMapper = new ObjectMapper();
		UserInfo readValue = objectMapper.readValue(req.getInputStream(), UserInfo.class);

		UserInfo createUser = UserRepository.getInstance().createUser(readValue);

		resp.getWriter().write(objectMapper.writeValueAsString(createUser));
	}

}
