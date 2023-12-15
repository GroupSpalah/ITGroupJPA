package org.example.country;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateEntity {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("test_jpa");

    public static void main(String[] args) {

        EntityManager em = FACTORY.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Country country = em.find(Country.class, 52);//entity put to persistence context

        update(country);

        transaction.commit();

        em.close();
    }

    public static void update(Country country) {//id != 0
        EntityManager em1 = FACTORY.createEntityManager();

        EntityTransaction transaction = em1.getTransaction();
        transaction.begin();

        country.setName("Canada1");

        Country country1 = em1.merge(country);

        em1.persist(country1);

        transaction.commit();

        em1.close();
        FACTORY.close();
    }
}

/**
 * main
 * findById -> Country
 * change some fields for country
 * update(country)
 */


