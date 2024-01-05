package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import org.example.homeworks.anton.hw_22_12_23.dao.CrudDaoA;
import org.example.homeworks.anton.hw_22_12_23.domain.Buyer;

import java.sql.SQLException;

public class BuyerDaoImpl implements CrudDaoA<Buyer> {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");

    @Override
    public void add(Buyer buyer) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(buyer);
        transaction.commit();
    }
    public Buyer findById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Buyer buyer = em.find(Buyer.class, id);
        System.out.println(buyer);
        transaction.commit();
        em.close();

        return buyer;
    }

    @Override
    public Buyer update(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Buyer buyer = em.find(Buyer.class, id);
        buyer.setCardNumber("123456");
        buyer.setName("Ivan");
        System.out.println(buyer);
        transaction.commit();
        em.close();
        return buyer;
    }


}
