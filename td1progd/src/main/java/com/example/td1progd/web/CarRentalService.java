package com.example.td1progd.web;

import com.example.td1progd.data.Car;
import com.example.td1progd.data.Moto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class CarRentalService {

    List<Car> cars = new ArrayList<Car>();
    List<Moto> motos = new ArrayList<Moto>();
    Logger logger = LoggerFactory.getLogger(CarRentalService.class);

    public CarRentalService() {
        Car car = new Car(1, "Ferrari","11AA22", 1000);
        cars.add(car);
        car = new Car(2, "Porsche", "33BB44", 2000);
        cars.add(car);
        car = new Car(3, "Peugeot", "44CC55", 500);
        cars.add(car);
        
        Moto moto = new Moto(1, "Kawasaki", "66DD77", 1000);
        motos.add(moto);
        moto = new Moto(2, "Honda", "88EE99", 2000);
        motos.add(moto);
        moto = new Moto(3, "Yamaha", "10FF11", 500);
        motos.add(moto);
    }
    



    @GetMapping("/bonjour")
    public String disBonjour(){
        return "Bonjour";
    }

    @GetMapping("/cars")
    public List<Car> getCars(){
        return cars;
    }

    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") int id) {
        logger.info("Recherche voiture ID: " + id);
        return cars.stream()
            .filter(car -> car.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
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




    @GetMapping("/motos")
    public List<Moto> getMotos(){
        return motos;
    }

    
    @GetMapping("/motos/{id}")
    public ResponseEntity<Moto> getMotoById(@PathVariable("id") int id) {
        logger.info("Recherche moto ID: " + id);
        return motos.stream()
            .filter(moto -> moto.getId() == id)
            .findFirst()
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    

    @PutMapping(value = "/moto/{plateNumber}")
    public void rentmoto(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam(value="rent") boolean rent,
            @RequestBody Dates dates){

        logger.info("PlateNumber : " + plateNumber);
        logger.info("Rent : " + rent);
        logger.info("Dates : " + dates);


    }

}