package com.warehousebe.warehousebe.repository;

import com.warehousebe.warehousebe.model.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WarehouseRepository extends JpaRepository<Warehouse, Integer> {
    
}
