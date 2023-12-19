package org.example.homeworks.anton.hw_15_12_23.service.impl;

import org.example.homeworks.anton.hw_15_12_23.dao.NotebookDao;
import org.example.homeworks.anton.hw_15_12_23.service.NotebookService;

import java.sql.SQLException;

public class NotebookServiceImpl implements NotebookService {
    private NotebookDao dao;
    @Override
    public void showById(int id) throws SQLException {
        dao.showById(id);
    }
}
