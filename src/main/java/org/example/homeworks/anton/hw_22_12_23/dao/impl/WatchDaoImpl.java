package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.homeworks.anton.hw_22_12_23.dao.WatchDao;


import org.example.homeworks.anton.hw_22_12_23.domain.WatchA;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;

import java.util.List;

public class WatchDaoImpl implements WatchDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");

    @Override
    public void add(WatchA watchA) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(watchA);
        transaction.commit();

    }

    @Override
    public WatchA findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        WatchA watchA = em.find(WatchA.class, id);
        System.out.println(watchA);
        transaction.commit();
        em.close();

        return watchA;

    }

    @Override
    public WatchA update(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        WatchA watchA = em.find(WatchA.class, id);
        watchA.setModel("Rolex");
        watchA.setPrice(1000);


        System.out.println(watchA);
        transaction.commit();
        em.close();
        return watchA;

    }


@Override
    public void showModelByType(WatchType watchType){
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<WatchA> query =
                em.createQuery("FROM WatchA w WHERE w.watchType = :w_type",
                        WatchA.class);
        query.setParameter("w_type", watchType);
        List<WatchA> watchAS = query.getResultList();
        System.out.println(watchAS);
        transaction.commit();
        em.close();
    }

    @Override
    public void showByPrice(int price) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<WatchA> query = em.createQuery("SELECT FROM WatchA w WHERE w.watchType = :MECHANICAL" +
                        "AND w.price < :price ",
                WatchA.class);
        query.setParameter("w_price", price);
        List<WatchA> resultList = query.getResultList();
        System.out.println(resultList);

        transaction.commit();
        em.close();
    }

    public void showWatchByCountry(String country) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<WatchA> query = em.createQuery("SELECT w.model FROM WatchA w WHERE w.manufacturer.country = " +
                        ":m_country"
                , WatchA.class);
        query.setParameter("m_country", country);
        List<WatchA> resultList = query.getResultList();
        System.out.println(resultList);

        transaction.commit();
        em.close();
    }
}
