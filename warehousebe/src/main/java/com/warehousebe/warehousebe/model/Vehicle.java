package com.warehousebe.warehousebe.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@Entity
public class Vehicle {

    @Id
    @JsonProperty("_id")
    private Integer id;

    private String make;
    private String model;

    @JsonProperty("year_model")
    private Integer yearModel;
    private Double price;
    private boolean licensed;

    @JsonProperty("date_added")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateAdded;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cars cars;

}
