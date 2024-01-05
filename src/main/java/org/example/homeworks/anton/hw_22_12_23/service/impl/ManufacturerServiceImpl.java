package org.example.homeworks.anton.hw_22_12_23.service.impl;


import org.example.homeworks.anton.hw_22_12_23.dao.ManufacturerDao;
import org.example.homeworks.anton.hw_22_12_23.dao.impl.ManufacturerDaoImpl;

import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;


import org.example.homeworks.anton.hw_22_12_23.service.ManufacturerService;

import java.sql.SQLException;

public class ManufacturerServiceImpl implements ManufacturerService {
    ManufacturerDao daoA;

    public ManufacturerServiceImpl() {
         daoA = new  ManufacturerDaoImpl();
    }

    @Override
    public void update(int id) throws SQLException {
        daoA.update(id);
    }

    @Override
    public void add(Manufacturer manufacturer) {
        daoA.add(manufacturer);
    }



    @Override
    public void findById(int id) throws SQLException {
        daoA.findById(id);

    }

    @Override
    public void showByPrice(double maxPrice) throws SQLException {
           daoA.showByPrice(maxPrice);
    }
}
