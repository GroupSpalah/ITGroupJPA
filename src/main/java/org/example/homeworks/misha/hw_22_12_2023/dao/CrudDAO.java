package org.example.homeworks.misha.hw_22_12_2023.dao;

import java.sql.SQLException;

public interface CrudDAO<T> {
    public void add(T t) throws SQLException;

}
