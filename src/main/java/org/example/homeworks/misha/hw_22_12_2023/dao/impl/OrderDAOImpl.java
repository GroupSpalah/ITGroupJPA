
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;;
import org.example.homeworks.misha.hw_22_12_2023.domain.Order;
import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;
import java.sql.SQLException;

public class OrderDAOImpl implements CrudDAO<Order> {

    @Override
    public void add(Order order) throws SQLException {
        @Cleanup
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        em.persist(order);

        transaction.commit();

    }

}

