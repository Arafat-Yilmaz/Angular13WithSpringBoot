package com.warehousebe.warehousebe.service;

import com.warehousebe.warehousebe.model.Vehicle;
import com.warehousebe.warehousebe.model.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface WarehouseService {

    List<Warehouse> getWarehouseList();
    Vehicle getVehicle(Integer id);

     void addWarehouseList(List<Warehouse> warehouseList);

}
