package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.homeworks.anton.hw_22_12_23.dao.CrudDao;
import org.example.homeworks.anton.hw_22_12_23.domain.Purchase;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;
import org.example.homeworks.misha.hw_22_12_2023.domain.OrderItem;

import java.sql.SQLException;

public class PurchaseDaoImpl implements CrudDao<Purchase> {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public void showById(int id) throws SQLException {

    }

    @Override
    public void showModelByType(WatchType watchType) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
            TypedQuery<OrderItem> query = em.createQuery(
                    "SELECT oi FROM OrderItem oi WHERE oi.watch.brand = :watchBrand", OrderItem.class);
            query.setParameter("watchBrand", watchType);
             query.getResultList();
        }

    @Override
    public void showByPrice(int price) throws SQLException {

    }
}

