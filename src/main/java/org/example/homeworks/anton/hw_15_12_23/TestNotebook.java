package org.example.homeworks.anton.hw_15_12_23;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;

public class TestNotebook {

    public static void main(String[] args) {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("antonio");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Notebook notebook = Notebook
                .builder()
                .manufacturer("Asus")
                .model("Vivibook")
                .date("2023-01-01")
                .ssd(500)
                .ram(16)
                .cpu("AMD")
                .build();

        em.persist(notebook);


        transaction.commit();

        em.close();
        factory.close();
    }
}


