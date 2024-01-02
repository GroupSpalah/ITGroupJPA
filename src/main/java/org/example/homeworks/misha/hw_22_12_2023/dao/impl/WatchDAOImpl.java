
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.example.homeworks.misha.hw_22_12_2023.dao.WatchDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.*;
import java.sql.SQLException;
import java.util.List;
import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;

public class WatchDAOImpl implements WatchDAO {

    @Override
    public void add(Watch watch) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Producer producer = em.find(Producer.class, 1);
        watch.setProducer(producer);

        em.persist(watch);

        transaction.commit();

    }

    @Override
    public Watch findById(int watchId) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Watch watch = em.find(Watch.class, watchId);

        transaction.commit();
        return watch;
    }
    @Override
    public void showByBrand(Type type) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Watch> query = em.createQuery("SELECT w FROM Watch w WHERE w.type = :w_type",
                Watch.class);
        query.setParameter("w_type", type);

        List<Watch> watch = query.getResultList();
        System.out.println(watch);

        transaction.commit();

    }

    @Override
    public void showInfoWatch(int price, Type type) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Watch> query =
                em.createQuery("SELECT w FROM Watch w WHERE w.price <= :w_price AND w.type = :w_type",
                        Watch.class);

        query.setParameter("w_price", price);
        query.setParameter("w_type", type);

        List<Watch> watch = query.getResultList();
        System.out.println(watch);

        transaction.commit();

    }

}

