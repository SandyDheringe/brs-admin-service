package com.brsadminservice.busroute;

import com.brsadminservice.exception.BRSResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BusRouteController {

    private final BusRouteService busRouteService;

    @Autowired
    BusRouteController(BusRouteService busRouteService) {
        this.busRouteService = busRouteService;
    }

    @PostMapping("/buses")
    ResponseEntity<BusRoute> saveBus(@RequestBody BusRoute bus) {
        BusRoute busDetail = busRouteService.saveBus(bus);
        return ResponseEntity.status(HttpStatus.CREATED).body(busDetail);
    }

    @PutMapping("/buses")
    ResponseEntity<BusRoute> updateBus(@RequestBody BusRoute bus) {
        BusRoute busDetail = busRouteService.saveBus(bus);
        return ResponseEntity.status(HttpStatus.OK).body(busDetail);
    }

    @GetMapping("/buses")
    ResponseEntity<List<BusRoute>> getAllBuses() {
        List<BusRoute> busDetail = busRouteService.getAllBuses();
        return ResponseEntity.status(HttpStatus.OK).body(busDetail);
    }

    @GetMapping("/buses/{bus_id}")
    ResponseEntity<BusRoute> getBus(@PathVariable("bus_id") Integer busId) {
        Optional<BusRoute> busDetail = busRouteService.getBus(busId);
        if(busDetail.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(busDetail.get());
        }
       else {
            throw new BRSResourceNotFoundException(String.format("Bus details with id %d not found",busId));
        }
    }

    @DeleteMapping("/buses/{bus_id}")
    ResponseEntity deleteBus(@PathVariable("bus_id") Integer busId) {
        BusRoute busDetail = busRouteService.deleteBus(busId);
        if(busDetail == null){
            throw new BRSResourceNotFoundException(String.format("Bus details with id %d not found",busId));
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
