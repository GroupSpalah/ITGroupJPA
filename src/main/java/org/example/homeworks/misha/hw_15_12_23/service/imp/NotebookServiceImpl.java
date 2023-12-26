package org.example.homeworks.misha.hw_15_12_23.service.imp;

import org.example.homeworks.misha.hw_15_12_23.dao.impl.NotebookDAOImpl;
import org.example.homeworks.misha.hw_15_12_23.domain.Notebook;
import org.example.homeworks.misha.hw_15_12_23.dao.NotebookDAO;
import org.example.homeworks.misha.hw_15_12_23.service.NotebookService;

import java.sql.SQLException;

public class NotebookServiceImpl implements NotebookService {

    private NotebookDAO dao;

    public NotebookServiceImpl() {
        dao = new NotebookDAOImpl();
    }

    @Override
    public void add() throws SQLException {
        dao.add();

    }

    @Override
    public void showByID(int id) throws SQLException {
        dao.showForID(id);

    }

    @Override
    public void showAll() throws SQLException {
        dao.showAll();

    }

    @Override
    public void deleteByID(int id) throws SQLException {
        dao.deleteForID(id);
    }

    @Override
    public void deleteAll() throws SQLException {
        dao.deleteAll();

    }

    @Override
    public void updateById(int id) throws SQLException {
        dao.updateForId(id);

    }

    @Override
    public void showForModel(String model) throws SQLException {
        dao.showForModel(model);

    }

    @Override
    public void showForDate(String date) throws SQLException {
        dao.showForDate(date);

    }

    @Override
    public void showForRamAndSsd(int ram, int ssd) throws SQLException {
        dao.showForRamAndSsd(ram, ssd);

    }

    @Override
    public void showForCpu(String cpu) throws SQLException {
        dao.showForCpu(cpu);

    }
}
