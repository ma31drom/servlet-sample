package by.pvt.service;

import java.util.List;

import by.pvt.models.Car;

public interface CarRepository {

	Car getById(Long id);

	List<Car> getAll();
	
	Car create(Car id);
}
