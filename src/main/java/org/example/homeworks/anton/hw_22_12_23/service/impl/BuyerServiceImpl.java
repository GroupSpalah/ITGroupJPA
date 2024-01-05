package org.example.homeworks.anton.hw_22_12_23.service.impl;

import org.example.homeworks.anton.hw_22_12_23.dao.CrudDaoA;
import org.example.homeworks.anton.hw_22_12_23.dao.impl.BuyerDaoImpl;
import org.example.homeworks.anton.hw_22_12_23.domain.Buyer;

import org.example.homeworks.anton.hw_22_12_23.service.CrudService;

import java.sql.SQLException;

public class BuyerServiceImpl  implements CrudService<Buyer> {
     CrudDaoA<Buyer> daoA;

    public BuyerServiceImpl() {
         daoA = new BuyerDaoImpl();
    }

    @Override
    public void update(int id) throws SQLException {
        daoA.update(id);
    }

    @Override
    public void add(Buyer buyer) {
   daoA.add(buyer);
    }



    @Override
    public void findById(int id) throws SQLException {
       daoA.findById(id);

    }
}
