package org.example.relationships.one_to_one.bi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestOneToOneBi {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Address address = Address
                .builder()
                .city("Kiev")
                .country("Ukraine")
                .build();

        Person jack = Person
                .builder()
                .age(32)
                .address(address)
                .name("Jack")
                .build();

        address.setPerson(jack);

//        em.persist(jack);

        Person person = em.find(Person.class, 1);

        System.out.println(person);

        transaction.commit();

        em.close();
        factory.close();
    }
}
