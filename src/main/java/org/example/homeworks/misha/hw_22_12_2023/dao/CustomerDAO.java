package org.example.homeworks.misha.hw_22_12_2023.dao;

import org.example.homeworks.misha.hw_22_12_2023.domain.Customer;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;

import java.sql.SQLException;

public interface CustomerDAO extends CrudService<Customer> {
    public Customer findById(int customerId) throws SQLException;
}
