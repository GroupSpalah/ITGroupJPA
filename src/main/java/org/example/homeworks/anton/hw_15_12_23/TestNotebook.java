package org.example.homeworks.anton.hw_15_12_23;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;
import org.example.homeworks.anton.hw_15_12_23.service.NotebookService;
import org.example.homeworks.anton.hw_15_12_23.service.impl.NotebookServiceImpl;

import java.sql.SQLException;

public class TestNotebook {

    public static void main(String[] args) throws SQLException {
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


        Notebook notebook2 = Notebook
                .builder()
                .manufacturer("HP")
                .model("Omen")
                .date("2022-02-02")
                .ssd(256)
                .ram(8)
                .cpu("Intel")
                .build();

        transaction.commit();
        em.close();
         NotebookService service = new NotebookServiceImpl();
       /*  service.showById(2);
         service.showByModel("Omen");
         service.showAll();
         service.removeById(352);
         service.removeAll();
         service.showByDate("2023-01-01");
         service.showBySsdRam(16,500);
         service.showByCpu("AMD");
         service.updateById(notebook, 752);*/
    }
}


