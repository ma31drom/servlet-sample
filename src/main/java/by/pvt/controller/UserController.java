package by.pvt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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

import by.pvt.models.StringBody;
import by.pvt.models.UserFilter;
import by.pvt.models.UserInfo;
import by.pvt.service.IUserRepository;
import by.pvt.service.JPAUserRepo;

@RestController
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	private IUserRepository repo;
	@Autowired
	private JPAUserRepo jpaRepo;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<UserInfo> getAllUsers() throws SQLException {
		return repo.getAllUsers();
	}

	@GetMapping
	public UserInfo getUserById(@RequestParam Long id) throws SQLException {
		return jpaRepo.findById(id).get();
	}

	@GetMapping(path = "/name")
	public UserInfo getUserByName(@RequestParam String name) throws SQLException {
		return jpaRepo.findByName(name);
	}

	@DeleteMapping
	public boolean deleteUserById(@RequestParam Long id) throws SQLException {
		return repo.deleteUserById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserInfo saveUser(@RequestBody UserInfo user) throws SQLException {
		return repo.createUser(user);
	}

	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserInfo updateUser(@RequestBody UserInfo user) throws SQLException {
		return repo.updateUser(user);
	}

	@PostMapping(path = "/query")
	public List<UserInfo> getUserByNamePatternAndSalaryMin(@RequestBody UserFilter filter) throws SQLException {
		return repo.getByNamePaternAndSalaryMoreThen(filter.getNamePattern(), filter.getSalary());
	}

	@PostMapping(path = "/query/string")
	public List<UserInfo> getUserByDoubleStringParam(@RequestBody StringBody filter) throws SQLException {
		return repo.getByStringIn2Fields(filter.getString());
	}

	@PostMapping(path = "/salary/avg")
	public String getMediumSalary() throws SQLException {
		return repo.mediumSalary();
	}

	@GetMapping(path = "/phone")
	public UserInfo getUserByPhoneNumber(@RequestParam String phone) throws SQLException {
		return repo.getUserByPhoneNumber(phone);
	}
}
