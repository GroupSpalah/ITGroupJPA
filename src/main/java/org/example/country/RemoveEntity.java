package org.example.country;

import jakarta.persistence.*;

public class RemoveEntity {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        /*Country country = em.find(Country.class, 1);

        em.remove(country);*/

        Query query = em.createQuery("DELETE FROM Country c WHERE c.id =: c_id");

        query.setParameter("c_id", 2);

        query.executeUpdate();

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
