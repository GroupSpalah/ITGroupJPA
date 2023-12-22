package org.example.relationships.one_to_many.uni;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.relationships.one_to_one.bi.Address;
import org.example.relationships.one_to_one.bi.Person;

import java.util.List;

public class TestOneToManyUni {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Student john = Student
                .builder()
                .age(32)
                .name("John")
                .build();

        Student jack = Student
                .builder()
                .age(14)
                .name("Jack")
                .build();

        Group group = Group
                .builder()
                .students(List.of(john, jack))
                .name("IT")
                .build();

        em.persist(group);

        transaction.commit();

        em.close();
        factory.close();
    }
}
