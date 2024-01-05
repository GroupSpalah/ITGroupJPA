
package org.example.homeworks.misha.hw_22_12_2023.service.imp;

import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.dao.impl.OrderDAOImpl;
import org.example.homeworks.misha.hw_22_12_2023.domain.Order;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;

import java.sql.SQLException;

public class OrderServiceImpl implements CrudService<Order> {

    private CrudDAO<Order> dao;

    public OrderServiceImpl() {
        dao = new OrderDAOImpl();
    }

    @Override
    public void add(Order order) throws SQLException {
        dao.add(order);

    }

    @Override
    public Order findById(int id) throws SQLException {
        return dao.findById(id);
    }
}

