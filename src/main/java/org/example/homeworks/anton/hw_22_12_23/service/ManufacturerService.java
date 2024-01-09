package org.example.homeworks.anton.hw_22_12_23.service;

import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;

import java.sql.SQLException;

public interface ManufacturerService extends CrudService<Manufacturer> {
    public void showBySomePrice(double maxPrice) throws SQLException;
}
