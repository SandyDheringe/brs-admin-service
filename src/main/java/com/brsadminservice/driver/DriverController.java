package com.brsadminservice.driver;

import com.brsadminservice.exception.BRSResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/driver")
public class DriverController {

    DriverService driverService;

    @Autowired
    DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostMapping
    ResponseEntity<Driver> saveDriver(@RequestBody Driver driver) {
        Driver driverDetail = driverService.saveDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverDetail);
    }

    @PutMapping
    ResponseEntity<Driver> updateDriver(@RequestBody Driver driver) {
        Driver driverDetail = driverService.saveDriver(driver);
        return ResponseEntity.status(HttpStatus.CREATED).body(driverDetail);
    }

    @GetMapping
    ResponseEntity<List<Driver>> getAllDriver() {
        List<Driver> driver = driverService.getAllDriver();
        return ResponseEntity.status(HttpStatus.CREATED).body(driver);
    }

    @GetMapping("/{driver_id}")
    ResponseEntity<Driver> getDriver(@PathVariable("driver_id") Integer driverId) {
        Optional<Driver> driverDetails = driverService.getDriver(driverId);
        if(driverDetails.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(driverDetails.get());
        }
        else {
            throw new BRSResourceNotFoundException(String.format("Driver details with id %d not found",driverId));
        }
    }
//
//    @DeleteMapping("/{driver_id}")
//    ResponseEntity<Driver> deleteDriver(@PathVariable("driver_id") Integer driverId) {
//        Driver driverDetail = driverService.deleteDriver(driverId);
//        if(driverDetail == null){
//            throw new BRSResourceNotFoundException(String.format("Driver details with id %d not found",driverId));
//        }
//        return ResponseEntity.status(HttpStatus.CREATED).body(driverDetail);
//    }
}
