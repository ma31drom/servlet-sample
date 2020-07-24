package by.pvt.service;

import java.util.List;

import by.pvt.models.UserInfo;

public interface IUserRepository {

	List<UserInfo> getAllUsers();

	UserInfo getUserById(Long id);

	boolean deleteUserById(Long id);

	List<UserInfo> getByNamePaternAndSalaryMoreThen(String namePattern, Double salaryLimit);

	List<UserInfo> getByStringIn2Fields(String filter);
	
	UserInfo createUser(UserInfo readValue);

	UserInfo updateUser(UserInfo user);

	String mediumSalary();
	
	UserInfo getUserByPhoneNumber(String phone);
	
}
