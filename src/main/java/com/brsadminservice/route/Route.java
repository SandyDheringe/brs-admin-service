package com.brsadminservice.route;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "route", schema = "bus_reservation_db")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id", nullable = false)
    private Integer id;

    @Column(name = "bus_id", nullable = false)
    private Integer busId;

    @Column(name = "source", length = 100)
    private String source;

    @Column(name = "destination", length = 100)
    private String destination;

    @Column(name = "distance")
    private Integer distance;

    @Column(name = "duration", length = 20)
    private String duration;

    @Column(name = "fare_amount")
    private Float fareAmount;

    @JsonIgnore
    @Column(name = "is_deleted")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private Boolean isDeleted = false;
}