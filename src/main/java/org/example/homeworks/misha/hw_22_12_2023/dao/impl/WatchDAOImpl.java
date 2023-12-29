
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;

import jakarta.persistence.*;
import lombok.Cleanup;
import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.*;
import java.sql.SQLException;
import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;

public class WatchDAOImpl implements CrudDAO<Watch> {

    @Override
    public void add(Watch watch) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Producer producer = em.find(Producer.class, 1);
        watch.setProducer(producer);

        em.persist(watch);

        transaction.commit();

    }
}

