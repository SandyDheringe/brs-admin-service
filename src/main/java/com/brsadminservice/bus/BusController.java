package com.brsadminservice.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bus")
public class BusController {

    BusService busService;

    @Autowired
    BusController(BusService busService) {
        this.busService = busService;
    }

    //https://api.brsservice.com/brs-admin-service/bus
    @PostMapping("")
    ResponseEntity<Bus> saveBus(@RequestBody Bus bus) {
        Bus busDetail = busService.saveBus(bus);
        return ResponseEntity.status(HttpStatus.CREATED).body(busDetail);
    }

    //https://api.brsservice.com/brs-admin-service/bus
    @PutMapping("")
    ResponseEntity<Bus> updateBus(@RequestBody Bus bus) {
        Bus busDetail = busService.saveBus(bus);
        return ResponseEntity.status(HttpStatus.CREATED).body(busDetail);
    }

    //https://api.brsservice.com/brs-admin-service/bus
    @GetMapping("")
    ResponseEntity<List<Bus>> getAllBuses() {
        List<Bus> busDetail = busService.getAllBuses();
        return ResponseEntity.status(HttpStatus.CREATED).body(busDetail);
    }

    //https://api.brsservice.com/brs-admin-service/bus
    @GetMapping("/{bus_id}")
    ResponseEntity<Bus> getAllBuses(@PathVariable("bus_id") Integer busId) {
        Optional<Bus> busDetail = busService.getBus(busId);

        return ResponseEntity.status(HttpStatus.CREATED).body(busDetail.get());
    }


}
