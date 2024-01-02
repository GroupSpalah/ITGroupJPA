package org.example.homeworks.anton.hw_22_12_23.service;

import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

public interface ManufacturerService {
    public void showModelByType(WatchType watchType) throws SQLException;
    public void showByPrice(int price) throws SQLException;
}
