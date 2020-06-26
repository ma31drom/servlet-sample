package by.pvt.service;

import java.sql.SQLException;
import java.util.List;

import by.pvt.models.UserInfo;

public interface IUserRepository {

	List<UserInfo> getAllUsers() throws SQLException;

	UserInfo getUserById(Long id) throws SQLException;

	boolean deleteUserById(Long id) throws SQLException;
}
