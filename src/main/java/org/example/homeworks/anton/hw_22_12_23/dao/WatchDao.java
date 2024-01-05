package org.example.homeworks.anton.hw_22_12_23.dao;

import org.example.homeworks.anton.hw_22_12_23.domain.WatchA;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

public interface WatchDao extends CrudDaoA<WatchA> {
    public void showModelByType(WatchType type) throws SQLException;

    void showByPrice(int price) throws SQLException;
    void showWatchByCountry(String country) throws SQLException;
}
