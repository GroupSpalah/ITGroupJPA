package org.example.homeworks.anton.hw_22_12_23.service.impl;

import org.example.homeworks.anton.hw_22_12_23.dao.WatchDao;
import org.example.homeworks.anton.hw_22_12_23.dao.impl.WatchDaoImpl;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchA;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;
import org.example.homeworks.anton.hw_22_12_23.service.WatchaService;

import java.sql.SQLException;

public class WatchAServiceImpl implements WatchaService {
    WatchDao dao;

    public WatchAServiceImpl() {
        dao = new WatchDaoImpl();
    }

    @Override
    public void showModelByType(WatchType watchType) throws SQLException {
       dao.showModelByType(watchType);
    }

    @Override
    public void showWatchByCountry(String country) throws SQLException {
                dao.showWatchByCountry(country);
    }

    @Override
    public void update(WatchA watchA) throws SQLException {
        dao.update(watchA);
    }

    @Override
    public void add(WatchA watchA) {
        dao.add(watchA);
    }

    @Override
    public WatchA findById(int id) throws SQLException {
       return dao.findById(id);

    }

    public void showByPrice(WatchType watchType,int price) throws SQLException{
        dao.showByPrice(watchType,price);
    }
}
