package by.pvt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import by.pvt.models.Car;

@Component
@Primary
public class JPARepoBasedImpl implements CarRepository {

	@Autowired
	CarRepo repo;

	@Override
	public Car getById(Long id) {
		Optional<Car> findById = repo.findById(id);
		if (findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public List<Car> getAll() {
		return repo.findAll();
	}

	@Override
	public Car create(Car id) {
		return repo.save(id);
	}

}
