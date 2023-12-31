package org.example.country;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestJpa {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Country country = Country
                .builder()
                .age(15)
                .name("Sweden")
                .state(State.ODESSA)
                .build();

        em.persist(country);//move to persistence context

        country.setName("England");

        transaction.commit();

        em.close();
        factory.close();
    }
}

/**
 * 1 - insert
 * 2 - delete
 * 3 - create
 * 4 - update
 */
