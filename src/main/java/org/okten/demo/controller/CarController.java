package org.okten.demo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.okten.demo.dto.CarDto;
import org.okten.demo.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    @GetMapping()
    public ResponseEntity<List<CarDto>> getCars() {
        return ResponseEntity.ok(carService.getAllCars());
    }

    @PostMapping()
    public ResponseEntity<CarDto> createCar(@RequestBody @Valid CarDto carDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(carService.createCar(carDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCar(@PathVariable int id) {
        return ResponseEntity.ok(carService.getCarById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable int id) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .build();
    }
}
