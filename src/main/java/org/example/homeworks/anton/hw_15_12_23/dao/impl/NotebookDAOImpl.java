package org.example.homeworks.anton.hw_15_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.country.Country;
import org.example.homeworks.anton.hw_15_12_23.dao.NotebookDao;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;

import java.sql.SQLException;


public class NotebookDAOImpl implements NotebookDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");

    public void showById(int id){

            EntityManager em = FACTORY.createEntityManager();

            EntityTransaction transaction = em.getTransaction();
            transaction.begin();

            Notebook notebook = em.find(Notebook.class, id);

            System.out.println(notebook);

            transaction.commit();

            em.close();
    }
}

