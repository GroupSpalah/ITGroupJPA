
package org.example.homeworks.misha.hw_22_12_2023.service.imp;

import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.dao.impl.CustomerDAOImpl;
import org.example.homeworks.misha.hw_22_12_2023.domain.Customer;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;

import java.sql.SQLException;

public class CustomerServiceImpl implements CrudService<Customer> {

    private CrudDAO<Customer> dao;

    public CustomerServiceImpl() {
        dao = new CustomerDAOImpl();
    }

    @Override
    public void add(Customer customer) throws SQLException {
        dao.add(customer);

    }
}

