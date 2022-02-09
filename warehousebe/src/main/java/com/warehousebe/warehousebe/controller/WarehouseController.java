package com.warehousebe.warehousebe.controller;


import com.warehousebe.warehousebe.model.Vehicle;
import com.warehousebe.warehousebe.model.Warehouse;
import com.warehousebe.warehousebe.service.WarehouseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class WarehouseController {

    final WarehouseService warehouseService;

    @GetMapping("/warehouse")
    public List<Vehicle> getAllWarehouse() {
        List<Vehicle> listOfVehicle = new ArrayList<>();
        List<Warehouse> listOfWarehouse= warehouseService.getWarehouseList();
        for(Warehouse warehouse:listOfWarehouse){
                for (Vehicle vehicle:warehouse.getCars().getVehicles()){
                    listOfVehicle.add(vehicle);
                }
        }
        Collections.sort(listOfVehicle, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                if(v1.getDateAdded().before(v2.getDateAdded())){
                    return -1;
                }
                return 1;
            }
        });
        return listOfVehicle;
    }


    @GetMapping("/warehouse/{id}")
    public Vehicle getVehicle(@PathVariable Integer id) {
        return warehouseService.getVehicle(id);
    }

    @PostMapping("/warehouse")
    @ResponseStatus(HttpStatus.CREATED)
    public void addWarehouseList(@RequestBody List<Warehouse> warehouseList) {
        warehouseService.addWarehouseList(warehouseList);
    }

}
