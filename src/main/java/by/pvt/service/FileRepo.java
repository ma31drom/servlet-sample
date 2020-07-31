package by.pvt.service;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import by.pvt.models.Car;

@Component
public class FileRepo implements CarRepository {

	private static final String CARS_DAT = "cars.dat";
	private AtomicInteger counter = new AtomicInteger(1);
	private Map<Long, Car> cars = new HashMap<>();

	public FileRepo() throws IOException {

		File file = new File(CARS_DAT);
		if (!file.exists()) {
			file.createNewFile();
		} else {
			Car[] readValue = new ObjectMapper().readValue(file, Car[].class);
			Stream.of(readValue).forEach(car -> cars.put(car.getId(), car));
		}

	}

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

		try {
			new ObjectMapper().writeValue(new File(CARS_DAT), cars.values());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return id;
	}

}
