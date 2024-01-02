package org.example.homeworks.misha.hw_22_12_2023.service;
import org.example.homeworks.misha.hw_22_12_2023.dao.ProducerDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.Producer;

import java.sql.SQLException;

public interface ProducerService extends ProducerDAO {
    public void showWatchByCountry(String country) throws SQLException;
    public void showProducer(int totalPrice) throws SQLException;


}
