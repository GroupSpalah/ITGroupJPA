package org.example.inheritance.single_table;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.inheritance.mapped_super_class.BigDog;
import org.example.inheritance.mapped_super_class.SmallDog;

public class TestST {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        BigCat jack = BigCat
                .builder()
                .name("Jack")
                .isTail(false)
                .build();

        SmallCat barsik = SmallCat
                .builder()
                .name("Barsik")
                .size(10)
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
