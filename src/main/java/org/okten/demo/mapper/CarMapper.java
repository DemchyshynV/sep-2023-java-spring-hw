package org.okten.demo.mapper;


import org.okten.demo.dto.CarDto;
import org.okten.demo.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    public CarDto mapToDto(Car car) {
        return CarDto.builder()
                .id(car.getId())
                .brand(car.getBrand())
                .price(car.getPrice())
                .year(car.getYear())
                .build();
    }

    public Car mapToCar(CarDto carDto) {
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setPrice(carDto.getPrice());
        car.setYear(carDto.getYear());
        return car;
    }
}
