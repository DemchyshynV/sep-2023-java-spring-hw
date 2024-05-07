package org.okten.demo.service;

import lombok.RequiredArgsConstructor;
import org.okten.demo.dto.CarDto;
import org.okten.demo.entity.Car;
import org.okten.demo.mapper.CarMapper;
import org.okten.demo.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;


    public List<CarDto> getAllCars() {
        return carRepository
                .findAll()
                .stream()
                .map(carMapper::mapToDto)
                .toList();
    }

    public CarDto createCar(CarDto carDto) {
        Car savedCar = carRepository.save(carMapper.mapToCar(carDto));
        return carMapper.mapToDto(savedCar);
    }

    public CarDto getCarById(int id) {
        Car car = carRepository
                .findById(id)
                .orElseThrow(() -> new NoSuchElementException("car with this id does not exist"));
        return carMapper.mapToDto(car);
    }

    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
}
