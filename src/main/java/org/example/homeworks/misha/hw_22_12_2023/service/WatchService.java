package org.example.homeworks.misha.hw_22_12_2023.service;
import org.example.homeworks.misha.hw_22_12_2023.dao.WatchDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.Type;
import org.example.homeworks.misha.hw_22_12_2023.domain.Watch;

import java.sql.SQLException;

public interface WatchService extends WatchDAO {
    public Watch findById(int watchId) throws SQLException;
    public void showByBrand(Type type) throws SQLException;
    public void showInfoWatch(int price, Type type) throws SQLException;
}
