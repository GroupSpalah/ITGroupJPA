package org.example.homeworks.anton.hw_22_12_23.service;

import org.example.homeworks.anton.hw_22_12_23.domain.WatchA;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

public interface WatchaService extends CrudService<WatchA> {
    public void showModelByType(WatchType watchType) throws SQLException;

    void showWatchByCountry(String country) throws SQLException;
    public void showByPrice(WatchType watchType,int price) throws SQLException;
}
