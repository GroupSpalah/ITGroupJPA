
package org.example.homeworks.misha.hw_22_12_2023.service.imp;
import org.example.homeworks.misha.hw_22_12_2023.dao.ProducerDAO;
import org.example.homeworks.misha.hw_22_12_2023.dao.impl.ProducerDAOImpl;
import org.example.homeworks.misha.hw_22_12_2023.domain.Producer;
import org.example.homeworks.misha.hw_22_12_2023.service.ProducerService;

import java.sql.SQLException;

public class ProducerServiceImpl implements ProducerService {

    private ProducerDAO dao;

    public ProducerServiceImpl() {
        dao = new ProducerDAOImpl();
    }

    @Override
    public Producer findById(int id) throws SQLException {
        return null;
    }

    @Override
    public void add(Producer producer) throws SQLException {
        dao.add(producer);

    }

    @Override
    public void showWatchByCountry(String country) throws SQLException {
        dao.showWatchByCountry(country);

    }

    @Override
    public void showProducer(int totalPrice) throws SQLException {
        dao.showProducer(totalPrice);

    }
}

