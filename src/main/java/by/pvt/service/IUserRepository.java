package by.pvt.service;

import java.util.List;

import by.pvt.models.UserInfo;

public interface IUserRepository {

	List<UserInfo> getAllUsers();

	UserInfo getUserById(Long id);

	boolean deleteUserById(Long id);

	UserInfo createUser(UserInfo readValue);
}
