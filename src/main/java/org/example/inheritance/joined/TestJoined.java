package org.example.inheritance.joined;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.inheritance.single_table.BigCat;
import org.example.inheritance.single_table.SmallCat;

public class TestJoined {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        SmallMouse barsik = SmallMouse
                .builder()
                .size(10)
                .name("Barsik")
                .build();

        BigMouse jack = BigMouse
                .builder()
                .isGrey(true)
                .name("Jack")
                .build();

        em.persist(barsik);
        em.persist(jack);

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
