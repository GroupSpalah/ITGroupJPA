package org.example.country;

import jakarta.persistence.*;

public class FindEntity {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

//        Country country = em.find(Country.class, 1);

       /* TypedQuery<Country> query =
                em.createQuery("FROM Country c WHERE c.id =: c_id", Country.class);

        query.setParameter("c_id", 1);*/

        TypedQuery<Country> query =
                em.createQuery("FROM Country c WHERE c.name =: c_name", Country.class);

        query.setParameter("c_name", "Sweden");

        Country country = query.getSingleResult();

        System.out.println(country);

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
