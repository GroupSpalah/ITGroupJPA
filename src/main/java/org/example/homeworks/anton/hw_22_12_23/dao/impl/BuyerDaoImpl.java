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
    public Buyer update(Buyer buyer) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        buyer.setCardNumber("121111222");
        buyer.setName("Ihor");
        Buyer buyer1 = em.merge(buyer);
        em.persist(buyer1);
        System.out.println(buyer1);
        transaction.commit();
        return buyer1;
    }


}
