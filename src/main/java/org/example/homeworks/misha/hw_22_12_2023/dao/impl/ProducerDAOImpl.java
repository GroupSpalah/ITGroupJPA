
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import lombok.Cleanup;
import org.example.homeworks.misha.hw_22_12_2023.dao.ProducerDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.Producer;
import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;
import java.sql.SQLException;
import java.util.List;

public class ProducerDAOImpl implements ProducerDAO {

    @Override
    public void add(Producer producer) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(producer);

        transaction.commit();

    }

    @Override
    public void showWatchByCountry(String country) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Producer> query =
                em.createQuery("SELECT p FROM Producer p JOIN p.watches w WHERE p.country =: p_country",
                        Producer.class);
        query.setParameter("p_country", country);
        List<Producer> producer = query.getResultList();
        System.out.println(producer);

        transaction.commit();

    }

    @Override
    public void showProducer(int totalPrice) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        TypedQuery<Producer> query =
                em.createQuery("SELECT p, SUM (w.price) FROM Producer p JOIN p.watches w " +
                                "GROUP BY p HAVING SUM(w.price) <=: w_total_price", Producer.class);
        query.setParameter("w_total_price", totalPrice);
        List<Producer> producer = query.getResultList();
        System.out.println(producer);

        transaction.commit();

    }

}

