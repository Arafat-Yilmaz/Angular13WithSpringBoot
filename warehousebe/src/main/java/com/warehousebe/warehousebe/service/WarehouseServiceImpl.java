package com.warehousebe.warehousebe.service;

import com.warehousebe.warehousebe.model.Vehicle;
import com.warehousebe.warehousebe.model.Warehouse;
import com.warehousebe.warehousebe.repository.VehicleRepository;
import com.warehousebe.warehousebe.repository.WarehouseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WarehouseServiceImpl implements WarehouseService {

    final WarehouseRepository warehouseRepository;
    final VehicleRepository vehicleRepository;

    @Override
    public List<Warehouse> getWarehouseList() {
        return warehouseRepository.findAll();
    }

    @Override
    public Vehicle getVehicle(Integer id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("No Vehicle found with id '%s'.", id)));
    }

    @Override
    public void addWarehouseList(List<Warehouse> warehouseList) {
        warehouseRepository.saveAll(warehouseList);
    }

}
