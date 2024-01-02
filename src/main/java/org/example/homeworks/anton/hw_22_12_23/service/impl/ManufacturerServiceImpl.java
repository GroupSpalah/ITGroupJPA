package org.example.homeworks.anton.hw_22_12_23.service.impl;

import org.example.homeworks.anton.hw_22_12_23.dao.CrudDao;
import org.example.homeworks.anton.hw_22_12_23.dao.impl.ManufacturerDaoImpl;
import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;
import org.example.homeworks.anton.hw_22_12_23.service.ManufacturerService;

import java.sql.SQLException;

public class ManufacturerServiceImpl implements ManufacturerService {
    CrudDao<Manufacturer> manufacturerCrudDao;

    public ManufacturerServiceImpl() {
        manufacturerCrudDao = new ManufacturerDaoImpl();
    }

    @Override
    public void showModelByType(WatchType watchType) throws SQLException {
        manufacturerCrudDao.showModelByType(watchType);
    }

    @Override
    public void showByPrice(int price) throws SQLException {
          manufacturerCrudDao.showByPrice(price);
    }
}
