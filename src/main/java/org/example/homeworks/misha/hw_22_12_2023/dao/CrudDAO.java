package org.example.homeworks.misha.hw_22_12_2023.dao;

import org.example.homeworks.misha.hw_22_12_2023.domain.Customer;

import java.sql.SQLException;

public interface CrudDAO<T> {
    public void add(T t) throws SQLException;
    public T findById(int id) throws SQLException;


}
