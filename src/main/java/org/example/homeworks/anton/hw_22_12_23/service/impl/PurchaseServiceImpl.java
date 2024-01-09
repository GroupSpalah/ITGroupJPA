package org.example.homeworks.anton.hw_22_12_23.service.impl;

import org.example.homeworks.anton.hw_22_12_23.dao.CrudDaoA;
import org.example.homeworks.anton.hw_22_12_23.dao.impl.PurchaseDaoImpl;
import org.example.homeworks.anton.hw_22_12_23.domain.Purchase;
import org.example.homeworks.anton.hw_22_12_23.service.CrudService;

import java.sql.SQLException;

public class PurchaseServiceImpl implements CrudService<Purchase> {
    CrudDaoA<Purchase> daoA;

    public PurchaseServiceImpl() {
         daoA = new PurchaseDaoImpl();
    }

    @Override
    public void update(Purchase purchase) throws SQLException {
  daoA.update(purchase);
    }

    @Override
    public void add(Purchase purchase) {
  daoA.add(purchase);
    }

    @Override
    public Purchase findById(int id) throws SQLException {
 return    daoA.findById(id);

    }
}
