package org.example.homeworks.anton.hw_15_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.country.Country;
import org.example.homeworks.anton.hw_15_12_23.dao.NotebookDao;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;

import java.sql.SQLException;


public class NotebookDAOImpl implements NotebookDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");
    public static void main(String[] args) throws SQLException {


        EntityManager em = FACTORY.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.find(Notebook.class, 1);
        showById();
        transaction.commit();
        em.close();
    }



    public static void showById(){

            EntityManager em1 = FACTORY.createEntityManager();

            EntityTransaction transaction = em1.getTransaction();
            transaction.begin();

            TypedQuery<Notebook> query =
                    em1.createQuery("FROM Notebook n WHERE n.model =: n_model", Notebook.class);

            query.setParameter("n_model", "Vivibook");

            Notebook notebook = query.getSingleResult();

            System.out.println(notebook);

            transaction.commit();

            em1.close();
            FACTORY.close();
    }
}

