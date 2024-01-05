package org.example.homeworks.misha.hw_22_12_2023.dao;
import org.example.homeworks.misha.hw_22_12_2023.domain.Producer;

import java.sql.SQLException;

public interface ProducerDAO extends CrudDAO<Producer> {
    public void showWatchByCountry(String country) throws SQLException;
    public void showSumByPrice(int totalPrice) throws SQLException;


}
