package org.example.homeworks.anton.hw_22_12_23.dao.impl;

import jakarta.persistence.*;


import org.example.homeworks.anton.hw_22_12_23.dao.ManufacturerDao;
import org.example.homeworks.anton.hw_22_12_23.domain.Manufacturer;
import org.example.homeworks.anton.hw_22_12_23.domain.SumManufacturer;


import java.sql.SQLException;
import java.util.List;


public class ManufacturerDaoImpl implements ManufacturerDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    @Override
    public void add(Manufacturer manufacturer) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(manufacturer);
        transaction.commit();
    }

    @Override
    public Manufacturer findById(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Manufacturer manufacturer = em.find(Manufacturer.class, id);
        System.out.println(manufacturer);
        transaction.commit();
        em.close();

        return manufacturer;
    }


    @Override
    public Manufacturer update(Manufacturer manufacturer) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        manufacturer.setName("LG");
        manufacturer.setCountry("Cuba");
        Manufacturer manufacturer1 = em.merge(manufacturer);
        em.persist(manufacturer1);
        System.out.println(manufacturer1);
        transaction.commit();
        em.close();
        return manufacturer1;

    }


    @Override
    public void showByPrice(double maxPrice) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<SumManufacturer> query = em.createQuery("SELECT new" + "org.example.homeworks.anton.hw_22_12_23.domain." +
                "SumManufacturer(m.name,SUM (w.price))" + "FROM Manufacturer m " +
                "JOIN m.watches w GROUP BY m HAVING SUM(w.price) <=: w_maxPrice", SumManufacturer.class);
        query.setParameter("w_maxPrice",maxPrice);
        List<SumManufacturer> manufacturers = query.getResultList();
        System.out.println(manufacturers);
        transaction.commit();
    }
}


