/*
package org.example.homeworks.misha.hw_22_12_2023.dao.impl;

import jakarta.persistence.*;
import org.example.homeworks.misha.hw_22_12_2023.dao.CrudDAO;
import org.example.homeworks.misha.hw_22_12_2023.domain.*;

import java.sql.SQLException;
import java.util.List;

public class WatchDAOImpl implements CrudDAO<Watch> {

    public static final EntityManagerFactory FACTORY =
            Persistence.createEntityManagerFactory("misha");

    @Override
    public void add() throws SQLException {
        EntityManager em = FACTORY.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Watch watch = Watch
                .builder()
                .brand("R11")
                .price(300)
                .type(Type.MECHANICAL)
                .build();

        Watch watch1 = Watch
                .builder()
                .brand("R32")
                .price(500)
                .type(Type.ELECTRONIC)
                .build();

        Producer producer = Producer
                .builder()
                .watches(List.of(watch1, watch))
                .name("Rolex")
                .country("Switzerland")
                .build();
//
//        Customer jack = Customer
//                .builder()
//                .name("Jack")
//                .numberCard(21250)
//                .build();
//
//        Customer john = Customer
//                .builder()
//                .name("John")
//                .numberCard(21589)
//                .build();
//
//        OrderItem orderItem = OrderItem
//                .builder()
//                .watch(watch1)
//                .count(2)
//                .build();
//
//        OrderItem orderItem1 = OrderItem
//                .builder()
//                .watch(watch)
//                .count(3)
//                .build();
//
//        Order order = Order
//                .builder()
//                .localDate("2023-12-03")
//                .discount(15)
//                .customers(List.of(jack, john))
//                .orderItems(List.of(orderItem, orderItem1))
//                .build();
//
//
//        jack.setOrder(order);
//        john.setOrder(order);
//        orderItem1.setOrder(order);
//        orderItem.setOrder(order);

        watch1.setProducer(producer);
        watch.setProducer(producer);

        em.persist(producer);

        transaction.commit();
        em.close();

    }

}
*/
