package org.example.homeworks.anton.hw_22_12_23.service.impl;

import org.example.homeworks.anton.hw_22_12_23.dao.CrudDao;
import org.example.homeworks.anton.hw_22_12_23.dao.impl.BuyerDaoImpl;
import org.example.homeworks.anton.hw_22_12_23.domain.Buyer;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;
import org.example.homeworks.anton.hw_22_12_23.service.BuyerService;

import java.sql.SQLException;

public class BuyerServiceImpl implements BuyerService {
    private CrudDao<Buyer>  buyerCrudDao;

    public BuyerServiceImpl() {
        this.buyerCrudDao = new BuyerDaoImpl();
    }

    public void showById(int id) throws SQLException {
        buyerCrudDao.showById(id);
    }

    public void showModelByType(WatchType watchType) throws SQLException {
       buyerCrudDao.showModelByType(watchType);
   }
}
