package com.brsadminservice.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusRouteService {

    private final BusRouteRepository busRouteRepository;
    @Autowired
    BusRouteService(BusRouteRepository busRouteRepository){
        this.busRouteRepository = busRouteRepository;
    }
    public BusRoute saveBus(BusRoute bus) {
        return busRouteRepository.saveAndFlush(bus);
    }

    public List<BusRoute> getAllBuses() {
        return busRouteRepository.findAllByIsDeleted(false);
    }

    public Optional<BusRoute> getBus(Integer busId) {
        return busRouteRepository.findByIdAndIsDeleted(busId,false);
    }

    public BusRoute deleteBus(Integer busId) {
        BusRoute busDetail = busRouteRepository.findByIdAndIsDeleted(busId,false).orElse(null);
        if(busDetail!=null){
           busDetail.setIsDeleted(true);
           busRouteRepository.saveAndFlush(busDetail);
           return busDetail;
        }
        return null;
    }
}
