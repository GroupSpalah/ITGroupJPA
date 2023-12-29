package org.example.homeworks.misha.hw_22_12_2023.service;

import java.sql.SQLException;

public interface CrudService<T> {
    public void add(T t) throws SQLException;

}
