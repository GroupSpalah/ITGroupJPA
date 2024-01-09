package org.example.homeworks.anton.hw_22_12_23.dao;

import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;

import java.sql.SQLException;

public interface ManufacturerDao extends CrudDaoA<Manufacturer>{
    Manufacturer update(Manufacturer manufacturer) throws SQLException;

    public void showByPrice(double maxPrice) throws SQLException;
}
