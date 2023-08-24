package com.brsadminservice.route;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {


    List<Route> findAllByIsDeleted(Boolean isDeleted);

    Optional<Route> findByIdAndIsDeleted(Integer id, boolean isDeleted);
}