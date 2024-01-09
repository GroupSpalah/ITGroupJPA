package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.example.homeworks.anton.hw_22_12_23.dao.CrudDaoA;
import org.example.homeworks.anton.hw_22_12_23.domain.Purchase;

import java.sql.SQLException;
import java.time.LocalDate;

public class PurchaseDaoImpl implements CrudDaoA<Purchase> {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");

    @Override
    public void add(Purchase purchase) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(purchase);
        transaction.commit();
    }
    @Override
    public Purchase findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Purchase purchase = em.find(Purchase.class, id);
        System.out.println(purchase);
        transaction.commit();
        em.close();

        return purchase;
    }


    @Override
    public Purchase update(Purchase purchase) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        purchase.setDate(LocalDate.of(2021,1,22));
        Purchase purchase1 = em.merge(purchase);
        em.persist(purchase1);
        System.out.println(purchase1);
        transaction.commit();
        em.close();
        return purchase1;
    }
}

