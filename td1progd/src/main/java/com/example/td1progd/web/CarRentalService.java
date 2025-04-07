package com.example.td1progd.web;

import com.example.td1progd.data.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CarRentalService {

    List<Car> cars = new ArrayList<Car>();
    Logger logger = LoggerFactory.getLogger(CarRentalService.class);

    public CarRentalService() {
        Car car = new Car("Ferrari", 1000);
        cars.add(car);
        car = new Car("Porsche", 2000);
        cars.add(car);
        car = new Car("Peugeot", 500);
        cars.add(car);
    }

    @GetMapping("/bonjour")
    public String disBonjour(){
        return "Bonjour";
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return cars;
    }

    @PutMapping(value = "/cars/{plateNumber}")
    public void rent(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent") boolean rent,
            @RequestBody Dates dates){

        logger.info("PlateNumber : " + plateNumber);
        logger.info("Rent : " + rent);
        logger.info("Dates : " + dates);


    }

}