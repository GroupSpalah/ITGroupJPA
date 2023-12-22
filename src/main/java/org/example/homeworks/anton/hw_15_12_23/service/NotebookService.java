package org.example.homeworks.anton.hw_15_12_23.service;

import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;

import java.sql.SQLException;

public interface NotebookService {
    public void showById(int id) throws SQLException;

    public void showByModel(String model) throws SQLException;

    public void showAll() throws SQLException;

    public void removeById(int id) throws SQLException;

    public void removeAll() throws SQLException;

    public void showByDate(String date) throws SQLException;

    public void showBySsdRam(int ram, int ssd) throws SQLException;

    public void showByCpu(String cpu) throws SQLException;

    public void updateById(Notebook notebook, int id) throws SQLException;
}
