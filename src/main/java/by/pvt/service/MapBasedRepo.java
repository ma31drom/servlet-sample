package by.pvt.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import by.pvt.models.Car;

@Component
public class MapBasedRepo implements CarRepository {

	private AtomicInteger counter = new AtomicInteger(1);
	private Map<Long, Car> cars = new HashMap<>();

	@Override
	public Car getById(Long id) {
		return cars.get(id);
	}

	@Override
	public List<Car> getAll() {
		return cars.values().stream().collect(Collectors.toList());
	}

	@Override
	public Car create(Car id) {
		id.setId(Long.valueOf(counter.getAndIncrement()));
		cars.put(id.getId(), id);
		return id;
	}

}
