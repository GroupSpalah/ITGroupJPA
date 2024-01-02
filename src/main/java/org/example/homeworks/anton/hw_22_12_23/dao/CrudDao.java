package org.example.homeworks.anton.hw_22_12_23.dao;

import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

public interface CrudDao<T> {
  void add(T t);
  public void showById(int id) throws SQLException;

}
