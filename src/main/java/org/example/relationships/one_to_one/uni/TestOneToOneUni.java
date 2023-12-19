package org.example.relationships.one_to_one.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestOneToOneUni {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Phone phone = Phone
                .builder()
                .number("067")
                .build();

        Human john = Human
                .builder()
                .phone(phone)
                .name("John")
                .age(32)
                .build();

        em.persist(john);
//        em.persist(phone);

        transaction.commit();

        em.close();
        factory.close();
    }
}
