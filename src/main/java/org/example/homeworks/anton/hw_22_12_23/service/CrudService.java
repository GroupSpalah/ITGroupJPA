package org.example.homeworks.anton.hw_22_12_23.service;



import java.sql.SQLException;

public interface CrudService<T> {
    public void update(T  t) throws SQLException;
    void add(T t);


   T findById(int id) throws SQLException;
}
