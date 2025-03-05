package com.example.td1progd.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRentalService {

    private List<Car> cars = new ArrayList<>();

    public CarRentalService() {
        cars.add(new Car("11AA22", "Ferrari", 100, false));
        cars.add(new Car("33BB44", "Tesla", 1120, false));
        Car maybach = new Car("55CC66", "Maybach", 2200, true);
        maybach.setRentalPeriod(new RentalPeriod("2025-02-10", "2025-02-20"));
        cars.add(maybach);
        Car peugeot = new Car("77DD88", "Peugeot", 500, false);
        cars.add(peugeot);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Car> listOfCars() {
        return cars;
    }

    @GetMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public Car getCar(@PathVariable("plateNumber") String plateNumber) {
    	for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                return car;
            }
        }
        throw new RuntimeException("Car not found");
    }

    @PutMapping("/{plateNumber}")
    @ResponseStatus(HttpStatus.OK)
    public void rentOrReturnCar(
            @PathVariable("plateNumber") String plateNumber,
            @RequestParam("rent") boolean rent,
            @RequestBody(required = false) RentalPeriod rentalPeriod) {

        for (Car car : cars) {
            if (car.getPlateNumber().equals(plateNumber)) {
                if (rent) {
                    if (!car.isRented()) {
                        car.setRented(true);

                        if (rentalPeriod != null) {
                            System.out.println("Rental Period received: " + rentalPeriod.getBegin() + " to " + rentalPeriod.getEnd());
                            car.setRentalPeriod(rentalPeriod);  // ✅ Enregistrer la période
                        } else {
                            throw new RuntimeException("Rental period required when renting a car.");
                        }

                    } else {
                        throw new RuntimeException("Car is already rented");
                    }
                } else {
                    car.setRented(false);
                    car.setRentalPeriod(null);  // ✅ Effacer la période de location
                }
                return;
            }
        }
        throw new RuntimeException("Car not found");
    }

}

class Car {
    private String plateNumber;
    private String brand;
    private int price;
    private boolean rented;
    private RentalPeriod rentalPeriod;
    
    public Car(String plateNumber, String brand, int price, boolean rented) {
        this.plateNumber = plateNumber;
        this.brand = brand;
        this.price = price;
        this.rented = rented;
        this.rentalPeriod = null;
    }

    public String getPlateNumber() { 
    	return plateNumber; 
    }
    
    public void setPlateNumber(String plateNumber) {
    	this.plateNumber=plateNumber;
    }
    
    public String getBrand() { 
    	return brand; 
    }
    
    public void setBrand(String brand) {
    	this.brand=brand;
    }
    
    public int getPrice() { 
    	return price; 
    }
    public void setPrice(int price) {
    	this.price=price;
    }
    
    public boolean isRented() { 
    	return rented; 
    }
    public void setRented(boolean rented) { 
    	this.rented = rented; 
    }
    
    public RentalPeriod getRentalPeriod() { return rentalPeriod; } 
    
    public void setRentalPeriod(RentalPeriod rentalPeriod) { this.rentalPeriod = rentalPeriod; }
}

class RentalPeriod {
    private String begin;
    private String end;
    
    
    public RentalPeriod(String begin, String end) {  // ✅ Constructeur
        this.begin = begin;
        this.end = end;
    }
    public String getBegin(){
    	return begin; 
    }
    public void setBegin(String begin) {
    	this.begin = begin; 
    }
    public String getEnd(){ 
    	return end; 
    }
    public void setEnd(String end){ 
    	this.end = end; 
    }
}
