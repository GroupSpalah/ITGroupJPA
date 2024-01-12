package org.example.optimistic_locking;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class VersionRunnable implements Runnable {
    @Override
    public void run() {
        EntityManagerFactory managerFactory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager entityManager = managerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        OptPerson person = entityManager.find(OptPerson.class, 1);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        person.setName("FromThread");

        transaction.commit();
        entityManager.close();
        managerFactory.close();

    }
}
