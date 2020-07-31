package by.pvt.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import by.pvt.models.Car;
import by.pvt.service.CarRepository;

@RestController
@RequestMapping(path = "/car")
public class CarController {

	@Autowired
	private CarRepository repo;

	@RequestMapping(path = "/all", method = RequestMethod.GET)
	public List<Car> getAllUsers() throws SQLException {
		return repo.getAll();
	}

	@GetMapping(path = "/{id}")
	public Car getSkillById(@PathVariable Long id) throws SQLException {
		return repo.getById(id);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Car saveUser(@RequestBody Car car) throws SQLException {
		return repo.create(car);
	}

}
