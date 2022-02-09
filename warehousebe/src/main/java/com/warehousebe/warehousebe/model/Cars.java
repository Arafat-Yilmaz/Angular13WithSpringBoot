package com.warehousebe.warehousebe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Cars {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String location;

   // @OneToMany(mappedBy="cars")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cars")
    private List<Vehicle> vehicles;

    @JsonIgnore
    @OneToOne(mappedBy = "cars")
    private Warehouse warehouse;

}
