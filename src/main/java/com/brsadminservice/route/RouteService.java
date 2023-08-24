package com.brsadminservice.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService {

    RouteRepository routeRepository;
    @Autowired
    RouteService(RouteRepository routeRepository){
        this.routeRepository = routeRepository;
    }
    public Route saveRoute(Route route) {
        return routeRepository.saveAndFlush(route);
    }

    public List<Route> getAllRoute() {
        return routeRepository.findAllByIsDeleted(false);
    }

    public Optional<Route> getRoute(Integer routeId) {
        return routeRepository.findByIdAndIsDeleted(routeId,false);
    }

    public Route deleteRoute(Integer routeId) {
        Route routeDetail = routeRepository.findByIdAndIsDeleted(routeId,false).orElse(null);
        if(routeDetail!=null){
            routeDetail.setIsDeleted(true);
            routeRepository.saveAndFlush(routeDetail);
            return routeDetail;
        }
        return null;
    }

}
