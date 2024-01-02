package org.example.homeworks.anton.hw_22_12_23.service;

import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

public interface PurchaseService {
 public void showModelByType(WatchType watchType) throws SQLException;
}
