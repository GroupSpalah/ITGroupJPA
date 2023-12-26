package org.example.relationships.one_to_many.uni;

import jakarta.persistence.*;
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

//        em.persist(group);

//        Group group1 = em.find(Group.class, 2);

//        group1.getStudents().get(0);

        TypedQuery<Group> query =
                em.createQuery("FROM Group g JOIN FETCH g.students WHERE g.id =: g_id",
                        Group.class);

        query.setParameter("g_id", 2);

        List<Group> groups = query.getResultList();

        System.out.println(groups);

        transaction.commit();

        em.close();
        factory.close();

//        System.out.println(group1);

    }
}
