package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.homeworks.anton.hw_22_12_23.dao.CrudDao;
import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchA;
import org.example.homeworks.anton.hw_22_12_23.domain.WatchType;

import java.sql.SQLException;
import java.util.List;


public class ManufacturerDaoImpl implements CrudDao<Manufacturer> {
    public static final EntityManagerFactory FACTORY =
                Persistence.createEntityManagerFactory("antonio");


    @Override
    public void showById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Manufacturer manufacturer = em.find(Manufacturer.class, id);
            System.out.println(manufacturer);
            transaction.commit();
            em.close();
        }

    @Override
    public void showModelByType(WatchType t) throws SQLException {

    }




    @Override
    public void showByPrice(int price) throws SQLException{
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<WatchA> query = em.createQuery("SELECT FROM WatchA w WHERE w.watchType = :w_watchType = MECHANICAL " +
                        "AND w.price < 500 ",
                WatchA.class);
        query.setParameter("w_price", price);
        List<WatchA> resultList = query.getResultList();
        System.out.println(resultList);;

        transaction.commit();
        em.close();
    }
    }


