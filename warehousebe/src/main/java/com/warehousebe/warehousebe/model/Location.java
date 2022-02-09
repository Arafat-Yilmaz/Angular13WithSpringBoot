package com.warehousebe.warehousebe.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Location {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double lat;

    @JsonProperty("long")
    private Double locationLong;

    @JsonIgnore
    @OneToOne(mappedBy = "location")
    private Warehouse warehouse;

}
