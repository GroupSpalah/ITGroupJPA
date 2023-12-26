package org.example.relationships.many_to_one;

import jakarta.persistence.*;
import org.example.relationships.one_to_many.bi.Apple;
import org.example.relationships.one_to_many.bi.Tree;

import java.util.List;

public class TestManyToOne {
    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Autopark autopark = Autopark
                .builder()
                .name("City")
                .build();


//        em.persist(autopark);

        Autopark autopark1 = em.find(Autopark.class, 1);

        Vehicle vehicle = Vehicle
                .builder()
                .model("Bmw")
                .autopark(autopark1)
                .build();

//        em.persist(vehicle);

        TypedQuery<Vehicle> query =
                em.createQuery("FROM Vehicle v JOIN v.autopark a WHERE a.name =: a_name",
                        Vehicle.class);

        query.setParameter("a_name", "City");

        Vehicle vehicle1 = query.getSingleResult();

        System.out.println(vehicle1);

        transaction.commit();

        em.close();
        factory.close();
    }
}
