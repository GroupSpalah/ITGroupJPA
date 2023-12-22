package org.example.homeworks.anton.hw_15_12_23.service.impl;

import org.example.homeworks.anton.hw_15_12_23.dao.NotebookDao;
import org.example.homeworks.anton.hw_15_12_23.dao.impl.NotebookDAOImpl;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;
import org.example.homeworks.anton.hw_15_12_23.service.NotebookService;

import java.sql.SQLException;

public class NotebookServiceImpl implements NotebookService {
    private NotebookDao dao;

    public NotebookServiceImpl() {
        dao = new NotebookDAOImpl();
    }

    @Override
    public void showById(int id) throws SQLException {
        dao.showById(id);
    }

    @Override
    public void showByModel(String model) throws SQLException {
        dao.showByModel(model);
    }

    @Override
    public void showAll() throws SQLException {
        dao.showAll();
    }

    public void removeById(int id) throws SQLException {
        dao.removeById(id);
    }

    public void removeAll() throws SQLException {
        dao.removeAll();
    }

    public void showByDate(String date) throws SQLException {
        dao.showByDate(date);
    }

    public void showBySsdRam(int ram, int ssd) throws SQLException {
        dao.showBySsdRam(ram, ssd);
    }

    public void showByCpu(String cpu) throws SQLException {
        dao.showByCpu(cpu);
    }

    public void updateById(Notebook notebook, int id) throws SQLException {
        dao.updateById(notebook, id);
    }
}
