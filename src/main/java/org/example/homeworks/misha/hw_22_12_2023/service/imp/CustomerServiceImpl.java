
package org.example.homeworks.misha.hw_22_12_2023.service.imp;
import org.example.homeworks.misha.hw_22_12_2023.dao.CustomerDAO;
import org.example.homeworks.misha.hw_22_12_2023.dao.impl.CustomerDAOImpl;
import org.example.homeworks.misha.hw_22_12_2023.domain.Customer;
import org.example.homeworks.misha.hw_22_12_2023.service.CustomerService;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    private CustomerDAO dao;

    public CustomerServiceImpl() {
        dao = new CustomerDAOImpl();
    }

    @Override
    public void add(Customer customer) throws SQLException {
        dao.add(customer);

    }

    @Override
    public Customer findById(int customerId) throws SQLException {
        return dao.findById(customerId);
    }
}

