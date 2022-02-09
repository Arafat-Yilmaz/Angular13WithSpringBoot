package com.warehousebe.warehousebe.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cars_id", referencedColumnName = "id")
    private Cars cars;

}
