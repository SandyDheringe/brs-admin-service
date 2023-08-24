package com.brsadminservice.bus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    List<Bus> findAllByIsDeleted(boolean isDeleted);
    Optional<Bus> findByIdAndIsDeleted(Integer id, boolean isDeleted);
}