package com.brsadminservice.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRouteRepository extends JpaRepository<BusRoute, Integer> {

    List<BusRoute> findAllByIsDeleted(boolean isDeleted);
    Optional<BusRoute> findByIdAndIsDeleted(Integer id, boolean isDeleted);
}