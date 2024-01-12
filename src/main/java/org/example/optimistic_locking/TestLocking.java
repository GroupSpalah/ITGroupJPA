package org.example.optimistic_locking;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class TestLocking {
    public static void main(String[] args) {

        VersionRunnable runnable = new VersionRunnable();

        new Thread(runnable).start();


        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        /*OptPerson person = new OptPerson("John");

        entityManager.persist(person);*/

        OptPerson person = entityManager.find(OptPerson.class, 1);

        person.setName("TestLocking");

        transaction.commit();
        entityManager.close();
        managerFactory.close();

    }
}
