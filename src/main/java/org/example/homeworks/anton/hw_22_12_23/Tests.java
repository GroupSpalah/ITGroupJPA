package org.example.homeworks.anton.hw_22_12_23;


import org.example.homeworks.anton.hw_22_12_23.domain.*;
import org.example.homeworks.anton.hw_22_12_23.service.CrudService;
import org.example.homeworks.anton.hw_22_12_23.service.ManufacturerService;
import org.example.homeworks.anton.hw_22_12_23.service.WatchaService;
import org.example.homeworks.anton.hw_22_12_23.service.impl.BuyerServiceImpl;
import org.example.homeworks.anton.hw_22_12_23.service.impl.ManufacturerServiceImpl;
import org.example.homeworks.anton.hw_22_12_23.service.impl.PurchaseServiceImpl;
import org.example.homeworks.anton.hw_22_12_23.service.impl.WatchAServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.example.homeworks.anton.hw_22_12_23.domain.WatchType.QUARTZ;

public class Tests {
    public static void main(String[] args) throws SQLException {

        CrudService<Buyer> buyerService = new BuyerServiceImpl();
        CrudService<Purchase> purchaseService = new PurchaseServiceImpl();
        WatchaService watchaService = new WatchAServiceImpl();
        ManufacturerService manufacturerService = new ManufacturerServiceImpl();

        WatchA watch1 = WatchA
                .builder()
                .model("Super")
                .watchType(QUARTZ)
                .price(100).build();

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
        manufacturerService.add(manufacturer);


        OrderItema orderItem = OrderItema
                .builder()
                .count(3)
                .watchA(watch1)
                .build();


        Buyer byId = buyerService.findById(1);
        Purchase purchase = Purchase
                .builder()
                .date(LocalDate.of(2022, 12, 2))
                .orderItems(List.of(orderItem))
                .buyer(byId)
                .build();

        orderItem.setPurchase(purchase);
        purchaseService.add(purchase);

        Buyer buyer = Buyer
                .builder()
                .name("John")
                .cardNumber("112")
                .build();

        buyerService.add(buyer);
        purchase.setBuyer(buyer);


        /*watchaService.showModelByType(WatchType.ELECTRIC);*/
    }
}