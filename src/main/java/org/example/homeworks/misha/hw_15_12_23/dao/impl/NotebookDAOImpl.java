package org.example.homeworks.misha.hw_15_12_23.dao.impl;

import jakarta.persistence.*;
import org.example.homeworks.misha.hw_15_12_23.domain.Notebook;
import org.example.homeworks.misha.hw_15_12_23.dao.NotebookDAO;
import org.example.homeworks.misha.hw_15_12_23.domain.Producer;
import org.example.relationships.one_to_one.bi.Person;

import java.sql.*;
import java.util.List;

public class NotebookDAOImpl implements NotebookDAO {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("misha");

    @Override
    public void add() throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Notebook notebook = Notebook
                .builder()
                .model("D53")
                .releaseDate("2021-11-02")
                .ramAmount(8)
                .ssdCapacity(512)
                .cpu("CPU28")
                .build();

        Producer dell = Producer
                .builder()
                .name("Dell")
                .notebook(notebook)
                .build();

        notebook.setProducer(dell);

        em.persist(dell);

        transaction.commit();
        em.close();

    }


    @Override
    public void showForID(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Notebook notebook = em.find(Notebook.class, id);
        System.out.println(notebook);

        transaction.commit();
        em.close();

    }

    @Override
    public void showAll() throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Notebook> query =
                em.createQuery("FROM Notebook n", Notebook.class);
        List<Notebook> notebooks = query.getResultList();

        // notebooks.forEach(System.out::println);

        for (Notebook notebook : notebooks) {
            System.out.println(notebook);
        }

        transaction.commit();
        em.close();
    }

    @Override
    public void deleteForID(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("DELETE FROM Notebook n WHERE n.id =: n_id");
        query.setParameter("n_id", id);
        query.executeUpdate();

        transaction.commit();
        em.close();

    }

    @Override
    public void deleteAll() throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Query query = em.createQuery("DELETE FROM Notebook n");
        query.executeUpdate();

        transaction.commit();

    }

    @Override
    public void updateForId(int id) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Notebook notebook = em.find(Notebook.class, 52);
        notebook.setModel("FG5");
        transaction.commit();
        em.close();

    }

    @Override
    public void showForModel(String model) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query =
                em.createQuery("SELECT n FROM Notebook n WHERE n.model =: n_model", Notebook.class);
        query.setParameter("n_model", model);
        Notebook notebook = query.getSingleResult();
        System.out.println(notebook);

        transaction.commit();
        em.close();

    }

    @Override
    public void showForDate(String date) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query =
                em.createQuery("SELECT n FROM Notebook n WHERE n.releaseDate =: n_releaseDate", Notebook.class);
        query.setParameter("n_releaseDate", date);
        Notebook notebook = query.getSingleResult();
        System.out.println(notebook);

        transaction.commit();
        em.close();

    }

    @Override
    public void showForRamAndSsd(int ram, int ssd) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("SELECT n FROM Notebook n WHERE " +
                "n.ramAmount =: n_ramAmount AND n.ssdCapacity =: n_ssdCapacity", Notebook.class);
        query.setParameter("n_ramAmount", ram);
        query.setParameter("n_ssdCapacity", ssd);
        Notebook notebook = query.getSingleResult();
        System.out.println(notebook);
        transaction.commit();
        em.close();

    }

    @Override
    public void showForCpu(String cpu) throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("SELECT n FROM Notebook n WHERE n.cpu =: n_cpu", Notebook.class);
        query.setParameter("n_cpu", cpu);
        Notebook notebook = query.getSingleResult();
        System.out.println(notebook);
        transaction.commit();
        em.close();

    }
}
