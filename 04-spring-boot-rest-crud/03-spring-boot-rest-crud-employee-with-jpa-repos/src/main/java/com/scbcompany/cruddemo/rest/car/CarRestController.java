package com.scbcompany.cruddemo.rest.car;

import com.scbcompany.cruddemo.entity.Cars;
import com.scbcompany.cruddemo.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carapi")
public class CarRestController {
    private final ApplicationService applicationService;

    @Autowired
    public CarRestController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @GetMapping("/cars")
    public List<Cars> findAllCars() {
        return applicationService.findAllCars();
    }
    @GetMapping("/cars/{carId}")
    public Cars findCarById(@PathVariable int carId){
        return applicationService.findByIdCar(carId);
    }
    @PostMapping("/cars")
    public Cars createCar(@RequestBody Cars theCar){
        theCar.setId(0L);
        return applicationService.saveCar(theCar);
    }
    @PutMapping("/cars")
    public Cars updateCar(@RequestBody Cars theCar){
        return applicationService.saveCar(theCar);
    }
    @DeleteMapping("/cars/{deleteId}")
    public String deleteCar(@PathVariable int deleteId){
        applicationService.deleteCarById(deleteId);
        return deleteId+" is deleted!";
    }
}
