
package org.example.homeworks.misha.hw_22_12_2023.service.imp;
import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.dao.impl.ProducerDAOImpl;
import org.example.homeworks.misha.hw_22_12_2023.domain.Producer;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;

import java.sql.SQLException;

public class ProducerServiceImpl implements CrudService<Producer> {

    private CrudDAO<Producer> dao;

    public ProducerServiceImpl() {
        dao = new ProducerDAOImpl();
    }

    @Override
    public void add(Producer producer) throws SQLException {
        dao.add(producer);

    }
}

