package org.example.homeworks.anton.hw_22_12_23.dao;

import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

public interface CrudDao<T> {
  public void showById(int id) throws SQLException;


  public void showModelByType(WatchType t) throws SQLException;


  void showByPrice(int price) throws SQLException;
}
