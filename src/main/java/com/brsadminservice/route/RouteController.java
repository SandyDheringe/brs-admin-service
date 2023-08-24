package com.brsadminservice.route;

import com.brsadminservice.exception.BRSResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class RouteController {


    private final RouteService routeService;

    @Autowired
    RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PostMapping("/routes")
    ResponseEntity<Route> saveRoute(@RequestBody Route route) {
        Route routeDetail = routeService.saveRoute(route);
        return ResponseEntity.status(HttpStatus.CREATED).body(routeDetail);
    }

    @PutMapping("/routes")
    ResponseEntity<Route> updateRoute(@RequestBody Route route) {
        Route routeDetail = routeService.saveRoute(route);
        return ResponseEntity.status(HttpStatus.CREATED).body(routeDetail);
    }

    @GetMapping("/routes")
    ResponseEntity<List<Route>> getAllRoutes() {
        List<Route> routeDetails = routeService.getAllRoute();
        return ResponseEntity.status(HttpStatus.CREATED).body(routeDetails);
    }

    @GetMapping("/routes/{route_id}")
    ResponseEntity<Route> getRoute(@PathVariable("route_id") Integer routeId) {
        Optional<Route> routeDetail = routeService.getRoute(routeId);
        if(routeDetail.isPresent()){
            return ResponseEntity.status(HttpStatus.CREATED).body(routeDetail.get());
        }
        else {
            throw new BRSResourceNotFoundException(String.format("Route details with id %d not found",routeId));
        }
    }

    @DeleteMapping("/routes/{route_id}")
    ResponseEntity<Route> deleteRoute(@PathVariable("route_id") Integer routeId) {
        Route routeDetail = routeService.deleteRoute(routeId);
        if(routeDetail == null){
            throw new BRSResourceNotFoundException(String.format("Route details with id %d not found",routeId));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(routeDetail);
    }
}
