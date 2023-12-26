package org.example.relationships.many_to_many;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.example.relationships.one_to_many.uni.Group;
import org.example.relationships.one_to_many.uni.Student;

import java.util.List;

public class TestManyToMany {
    public static void main(String[] args) {
        @Cleanup
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("test_jpa");
        @Cleanup
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Item item1 = Item
                .builder()
                .name("Item1")
                .build();

        Item item2 = Item
                .builder()
                .name("Item2")
                .build();

        Orderm orderm = Orderm
                .builder()
                .items(List.of(item2, item1))
                .name("Some")
                .build();

        em.persist(orderm);

        transaction.commit();

    }
}
