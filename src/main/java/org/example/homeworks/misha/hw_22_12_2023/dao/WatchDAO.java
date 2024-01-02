package org.example.homeworks.misha.hw_22_12_2023.dao;
import org.example.homeworks.misha.hw_22_12_2023.domain.Type;
import org.example.homeworks.misha.hw_22_12_2023.domain.Watch;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;

import java.sql.SQLException;

public interface WatchDAO extends CrudService<Watch> {
    public Watch findById(int watchId) throws SQLException;
    public void showByBrand(Type type) throws SQLException;
    public void showInfoWatch(int price, Type type) throws SQLException;


}
