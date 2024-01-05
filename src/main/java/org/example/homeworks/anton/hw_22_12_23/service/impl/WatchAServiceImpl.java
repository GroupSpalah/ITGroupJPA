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

    }

    @Override
    public void update(int id) throws SQLException {
        dao.update(id);
    }

    @Override
    public void add(WatchA watchA) {
        dao.add(watchA);
    }

    @Override
    public void findById(int id) throws SQLException {
dao.findById(id);

    }
}
