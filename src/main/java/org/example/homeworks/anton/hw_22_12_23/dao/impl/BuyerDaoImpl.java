package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;
import org.example.homeworks.anton.hw_22_12_23.dao.CrudDao;
import org.example.homeworks.anton.hw_22_12_23.domain.Buyer;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchA;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;
import java.util.List;

public class BuyerDaoImpl implements CrudDao<Buyer> {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    public void showById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Buyer buyer = em.find(Buyer.class, id);
        System.out.println(buyer);
        transaction.commit();
        em.close();
    }

    @Override
    public void showModelByType(WatchType t) throws SQLException {

    }

    @Override
    public void showByPrice(int price) throws SQLException {

    }
}
