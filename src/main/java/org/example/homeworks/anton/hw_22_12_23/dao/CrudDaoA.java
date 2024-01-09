package org.example.homeworks.anton.hw_22_12_23.dao;





import java.sql.SQLException;
import java.time.LocalDate;

public interface CrudDaoA<T> {
  public T update(T t) throws SQLException;

  void add(T t);
  public T findById(int id) throws SQLException;



}
