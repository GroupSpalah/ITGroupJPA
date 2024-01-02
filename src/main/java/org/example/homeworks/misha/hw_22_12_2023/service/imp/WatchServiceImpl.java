
package org.example.homeworks.misha.hw_22_12_2023.service.imp;

import org.example.homeworks.misha.hw_22_12_2023.dao.WatchDAO;
import org.example.homeworks.misha.hw_22_12_2023.dao.impl.WatchDAOImpl;
import org.example.homeworks.misha.hw_22_12_2023.domain.Type;
import org.example.homeworks.misha.hw_22_12_2023.domain.Watch;
import org.example.homeworks.misha.hw_22_12_2023.service.WatchService;

import java.sql.SQLException;

public class WatchServiceImpl implements WatchService {

    private WatchDAO dao;

    public WatchServiceImpl() {
        dao = new WatchDAOImpl();
    }

    @Override
    public void add(Watch watch) throws SQLException {
        dao.add(watch);

    }

    @Override
    public Watch findById(int watchId) throws SQLException {
        return dao.findById(watchId);
    }

    @Override
    public void showByBrand(Type type) throws SQLException {
        dao.showByBrand(type);
    }

    @Override
    public void showInfoWatch(int price, Type type) throws SQLException {
        dao.showInfoWatch(price, type);

    }

}

