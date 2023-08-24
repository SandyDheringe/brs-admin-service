package com.brsadminservice.driver;

import com.brsadminservice.bus.Bus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DriverService {

    DriverRepository driverRepository;

    @Autowired
    DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.saveAndFlush(driver);
    }


    public List<Driver> getAllDriver() {
        return driverRepository.findAll();
    }

    public Optional<Driver> getDriver(Integer driverId) {
        return driverRepository.findById(driverId);
    }

//    public Driver deleteDriver(Integer driverId) {
//        Driver driverDetails =driverRepository.findById(driverId).orElse(null);
//        if(driverDetails!=null){
//            driverDetails.setIsDeleted(true);
//            busRepository.saveAndFlush(driverDetails);
//            return driverDetails;
//        }
//        return null;
//    }
}
