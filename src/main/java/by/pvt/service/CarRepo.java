package by.pvt.service;

import org.springframework.data.jpa.repository.JpaRepository;

import by.pvt.models.Car;

public interface CarRepo extends JpaRepository<Car, Long> {

}
