package org.example.inheritance.table_per_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.inheritance.single_table.BigCat;
import org.example.inheritance.single_table.SmallCat;

public class TestTPC {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        SmallBird barsik = SmallBird
                .builder()
                .size(10)
                .name("Barsik")
                .build();

        BigBird jack = BigBird
                .builder()
                .isTail(false)
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
