
package org.example.homeworks.misha.hw_22_12_2023.domain;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.CustomerServiceImpl;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.OrderServiceImpl;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.ProducerServiceImpl;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.WatchServiceImpl;

import static org.example.homeworks.misha.hw_22_12_2023.util.Constans.*;


import java.time.LocalDate;
import java.util.List;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {

        CrudService<Producer> producerService = new ProducerServiceImpl();
        CrudService<Customer> customerService = new CustomerServiceImpl();
        CrudService<Order> orderService = new OrderServiceImpl();

        Watch watch = new Watch(0, "R11", Type.MECHANICAL, 3000);
        Watch watch1 = new Watch(0, "R23", Type.ELECTRONIC, 5000);

        Producer producer = new Producer(0, "Rolex", "Switzerland", List.of(watch1, watch));

        OrderItem orderItem = new OrderItem(0,watch,2);
        OrderItem orderItem1 = new OrderItem(0,watch,2);

        Customer john = new Customer(0, "John", "4141 4245 4587 6668");

        Order order = new Order(0, LocalDate.now(), 0.1, john, List.of(orderItem, orderItem1));

        watch.setProducer(producer);
        watch1.setProducer(producer);

        producerService.add(producer);

        customerService.add(john);
        orderService.add(order);



    }
}

