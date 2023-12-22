package org.example.homeworks.misha.hw_15_12_23.service;

import org.example.homeworks.misha.hw_15_12_23.domain.Notebook;

import java.sql.SQLException;

public interface NotebookService {
    public void add() throws SQLException;

    public void showForID(int id) throws SQLException;

    public void showAll() throws SQLException;

    public void deleteForID(int id) throws SQLException;

    public void deleteAll() throws SQLException;

    public void updateForId(int id) throws SQLException;

    public void showForModel(String model) throws SQLException;

    public void showForDate(String date) throws SQLException;

    public void showForRamAndSsd(int ram, int ssd) throws SQLException;

    public void showForCpu(String cpu) throws SQLException;

}
