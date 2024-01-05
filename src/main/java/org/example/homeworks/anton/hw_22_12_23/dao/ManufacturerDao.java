package org.example.homeworks.anton.hw_22_12_23.dao;

import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;

import java.sql.SQLException;

public interface ManufacturerDao extends CrudDaoA<Manufacturer>{
    public void showByPrice(double maxPrice) throws SQLException;
}
