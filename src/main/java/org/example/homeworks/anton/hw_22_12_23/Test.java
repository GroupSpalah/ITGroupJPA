package org.example.homeworks.anton.hw_22_12_23;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.homeworks.anton.hw_22_12_23.domain.*;

import org.example.homeworks.anton.hw_22_12_23.service.BuyerService;
import org.example.homeworks.anton.hw_22_12_23.service.ManufacturerService;
import org.example.homeworks.anton.hw_22_12_23.service.OrderService;
import org.example.homeworks.anton.hw_22_12_23.service.impl.BuyerServiceImpl;
import org.example.homeworks.anton.hw_22_12_23.service.impl.ManufacturerServiceImpl;
import org.example.homeworks.anton.hw_22_12_23.service.impl.OrderServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;


import static org.example.homeworks.anton.hw_22_12_23.domain.WatchType.QUARTZ;

public class Test {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("antonio");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();


        Manufacturer manufacturer = Manufacturer
                    .builder()
                    .country("Ukraine")
                    .name("LG")
                    .build();

        WatchA watchA =  WatchA
                .builder()
                .manufacturer(manufacturer)
                .model("Super")
                .watchType(QUARTZ)
                .price(100).build();

        OrderItema orderItem = OrderItema
                .builder()
                .count(3)
                .watchA(watchA).build();


        Buyer buyer = Buyer
                .builder()
                .name("John")
                .cardNumber("112")
                .build();
        Ordera order = Ordera
                .builder()
                .date(LocalDate.now())
                .buyer(buyer)
                .build();

        transaction.commit();
        em.close();

        BuyerService service = new BuyerServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        ManufacturerService manufacturerService = new ManufacturerServiceImpl();
        service.showModelByType(QUARTZ);

    }
}
