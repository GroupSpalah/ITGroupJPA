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
    public WatchA update(WatchA watchA) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
       watchA.setPrice(102);
       watchA.setModel("Casio +");
        watchA.setPrice(1000);
WatchA watchA1 = em.merge(watchA);
em.persist(watchA1);
System.out.println(watchA);
        transaction.commit();
        em.close();
        return watchA1;

    }


@Override
    public void showModelByType(WatchType watchType){
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<WatchA> query =
                em.createQuery("SELECT w FROM WatchA w WHERE w.watchType = :w_watchType",
                        WatchA.class);
        query.setParameter("w_watchType", watchType);
        List<WatchA> watchAS = query.getResultList();
        System.out.println(watchAS);
        transaction.commit();
        em.close();
    }

    @Override
    public void showByPrice(WatchType watchType,int price) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<WatchA> query = em.createQuery(" SELECT w FROM WatchA w WHERE w.watchType = :w_watchType " +
                        "AND w.price <= :w_price",
                WatchA.class);
        query.setParameter("w_watchType",watchType);
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
        TypedQuery<WatchA> query = em.createQuery("SELECT w FROM WatchA w WHERE w.manufacturer.country = :country"
                , WatchA.class);
        query.setParameter("country", country);
        List<WatchA> resultList = query.getResultList();
        System.out.println(resultList);

        transaction.commit();
        em.close();
    }
}
