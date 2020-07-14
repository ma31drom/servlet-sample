package by.pvt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import by.pvt.models.UserInfo;
import by.pvt.service.IUserRepository;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private IUserRepository repo;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<UserInfo> getAllUsers() throws SQLException {
		return repo.getAllUsers();
	}

	@GetMapping
	public UserInfo getUserById(@RequestParam Long id) throws SQLException {
		return repo.getUserById(id);
	}

	@GetMapping(path = "/empl")
	public UserInfo getemployeeById(@RequestParam Long id) throws SQLException {
		return repo.getUEmployeeById(id);
	}
	
	@DeleteMapping
	public boolean deleteUserById(@RequestParam Long id) throws SQLException {
		return repo.deleteUserById(id);
	}

	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public UserInfo saveUser(@RequestBody UserInfo user) throws SQLException {
		return repo.createUser(user);
	}
	
	@PutMapping(consumes= MediaType.APPLICATION_JSON_VALUE)
	public UserInfo updateUser(@RequestBody UserInfo user) throws SQLException {
		return repo.updateUser(user);
	}
}
