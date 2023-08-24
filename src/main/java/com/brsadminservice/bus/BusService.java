package com.brsadminservice.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusService {

    BusRepository busRepository;
    @Autowired
    BusService(BusRepository busRepository){
        this.busRepository = busRepository;
    }
    public Bus saveBus(Bus bus) {
        return busRepository.saveAndFlush(bus);
    }

    public List<Bus> getAllBuses() {
        return busRepository.findAllByIsDeleted(false);
    }

    public Optional<Bus> getBus(Integer busId) {
        return busRepository.findByIdAndIsDeleted(busId,false);
    }

    public Bus deleteBus(Integer busId) {
        Bus busDetail =busRepository.findByIdAndIsDeleted(busId,false).orElse(null);
        if(busDetail!=null){
           busDetail.setIsDeleted(true);
           busRepository.saveAndFlush(busDetail);
           return busDetail;
        }
        return null;
    }
}
