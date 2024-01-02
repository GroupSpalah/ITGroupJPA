package org.example.homeworks.anton.hw_22_12_23;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.example.homeworks.anton.hw_22_12_23.domain.*;
import org.example.homeworks.anton.hw_22_12_23.service.BuyerService;
import org.example.homeworks.anton.hw_22_12_23.service.PurchaseService;
import org.example.homeworks.anton.hw_22_12_23.service.impl.BuyerServiceImpl;
import org.example.homeworks.anton.hw_22_12_23.service.impl.PurchaseServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.example.homeworks.anton.hw_22_12_23.domain.WatchType.QUARTZ;

public class Tests {
    public static void main(String[] args) throws SQLException {
        EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("antonio");
        EntityManager em = factory.createEntityManager();

        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        WatchA watch1 = WatchA
                .builder()
                .model("Super")
                .watchType(QUARTZ)
                .price(100)
                .build();

        WatchA watch2 = WatchA
                .builder()
                .model("Casio")
                .watchType(WatchType.ELECTRIC)
                .price(200).build();

        Manufacturer manufacturer = Manufacturer
                .builder()
                .country("Ukraine")
                .name("LG")
                .watches(List.of(watch1, watch2))
                .build();

        watch1.setManufacturer(manufacturer);
        watch2.setManufacturer(manufacturer);

        OrderItema orderItem = OrderItema
                .builder()
                .id(1)
                .count(3)
                .watchA(watch1).build();

        Purchase purchase = Purchase
                .builder()
                .date(LocalDate.of(2022, 12, 2))
                .orderItems(List.of(orderItem))
                .build();

        Purchase purchase1 = Purchase
                .builder()
                .date(LocalDate.of(2023, 1, 2))
                .orderItems(List.of(orderItem))
                .build();
        orderItem.setPurchase(purchase);
        orderItem.setPurchase(purchase1);

        /*Buyer buyer = Buyer
                .builder()
                .name("John")
                .cardNumber("112")
                .build();*/

        Buyer buyer = em.find(Buyer.class, 1);

        purchase1.setBuyer(buyer);
        purchase.setBuyer(buyer);
        em.persist(purchase);
       /* em.persist(manufacturer);
        em.persist(orderItem);
        em.persist(buyer);
       */
        transaction.commit();
        em.close();

        BuyerService buyerService = new BuyerServiceImpl();
        PurchaseService purchaseService = new PurchaseServiceImpl();

        buyerService.showById(1);
        purchaseService.showModelByType(QUARTZ);
    }
}
