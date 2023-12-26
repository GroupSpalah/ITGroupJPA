package org.example.homeworks.misha.hw_15_12_23.service;

import java.sql.SQLException;

public interface NotebookService {
    public void add() throws SQLException;

    public void showByID(int id) throws SQLException;

    public void showAll() throws SQLException;

    public void deleteByID(int id) throws SQLException;

    public void deleteAll() throws SQLException;

    public void updateById(int id) throws SQLException;

    public void showForModel(String model) throws SQLException;

    public void showForDate(String date) throws SQLException;

    public void showForRamAndSsd(int ram, int ssd) throws SQLException;

    public void showForCpu(String cpu) throws SQLException;

}
