package org.example.homeworks.anton.hw_15_12_23.dao.impl;

import jakarta.persistence.*;



import org.example.homeworks.anton.hw_15_12_23.dao.NotebookDao;
import org.example.homeworks.anton.hw_15_12_23.domain.Notebook;
import java.util.List;


public class NotebookDAOImpl implements NotebookDao {
    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("antonio");

    public void showById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Notebook notebook = em.find(Notebook.class, id);
        System.out.println(notebook);
        transaction.commit();
        em.close();
    }
    public void showByModel(String model) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("FROM Notebook n WHERE n.model = :n_model", Notebook.class);
        query.setParameter("n_model", model);
        Notebook notebook = query.getSingleResult();
        System.out.println(notebook);
        transaction.commit();
        em.close();
    }

    public void showAll() {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query =
                em.createQuery("FROM Notebook n", Notebook.class);
        List<Notebook> notebooks = query.getResultList();
        System.out.println(notebooks);
        transaction.commit();
        em.close();
    }

    public void removeById(int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Notebook n WHERE n.id =: n_id");
        query.setParameter("n_id", id);
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    public void removeAll() {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Query query = em.createQuery("DELETE FROM Notebook n");
        query.executeUpdate();
        transaction.commit();
        em.close();
    }

    public void showByDate(String date) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("FROM Notebook n WHERE n.date = :n_date", Notebook.class);
        query.setParameter("n_date", date);
        List<Notebook> notebook = query.getResultList();
        System.out.println(notebook);
        transaction.commit();
        em.close();
    }

    public void showBySsdRam(int ram, int ssd) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("FROM Notebook n WHERE n.ram = :n_ram AND n.ssd = :n_ssd",
                Notebook.class);
        query.setParameter("n_ram", ram);
        query.setParameter("n_ssd", ssd);
        List<Notebook> notebook = query.getResultList();
        System.out.println(notebook);
        transaction.commit();
        em.close();
    }

    public void showByCpu(String cpu) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        TypedQuery<Notebook> query = em.createQuery("FROM Notebook n WHERE n.cpu = :n_cpu", Notebook.class);
        query.setParameter("n_cpu", cpu);
        List<Notebook> notebook = query.getResultList();
        System.out.println(notebook);
        transaction.commit();
        em.close();
    }

    public void updateById(Notebook notebook, int id) {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        notebook.setModel("super");
        notebook.setManufacturer("IT");
        Notebook notebook1 = em.merge(notebook);

        em.persist(notebook1);
        transaction.commit();
        transaction.commit();
        em.close();
    }
}


