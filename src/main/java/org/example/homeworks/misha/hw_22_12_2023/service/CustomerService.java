package org.example.homeworks.misha.hw_22_12_2023.service;
import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.Customer;

import java.sql.SQLException;

public interface CustomerService extends CrudDAO<Customer> {
    public Customer findById(int customerId) throws SQLException;
}
