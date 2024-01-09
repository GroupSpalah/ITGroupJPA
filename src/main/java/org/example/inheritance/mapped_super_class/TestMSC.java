package org.example.inheritance.mapped_super_class;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.country.Country;
import org.example.country.State;

public class TestMSC {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        BigDog sam = BigDog
                .builder()
                .name("Sam")
                .isTail(true)
                .build();

        SmallDog barsik = SmallDog
                .builder()
                .length(10)
                .name("Barsik")
                .build();

        em.persist(barsik);
        em.persist(sam);

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
