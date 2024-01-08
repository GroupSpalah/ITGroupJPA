
package org.example.homeworks.misha.hw_22_12_2023.domain;

import lombok.SneakyThrows;
import org.example.homeworks.misha.hw_22_12_2023.service.CrudService;
import org.example.homeworks.misha.hw_22_12_2023.service.ProducerService;
import org.example.homeworks.misha.hw_22_12_2023.service.WatchService;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.CustomerServiceImpl;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.OrderServiceImpl;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.ProducerServiceImpl;
import org.example.homeworks.misha.hw_22_12_2023.service.imp.WatchServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        WatchService watchService = new WatchServiceImpl();
        ProducerService producerService = new ProducerServiceImpl();
        CrudService<Customer> customerService = new CustomerServiceImpl();
        CrudService<Order> orderService = new OrderServiceImpl();

        Watch watch = new Watch(0, "R11", Type.MECHANICAL, 3000);
        Watch watch1 = new Watch(0, "R23", Type.ELECTRONIC, 5000);

        Producer producer = new Producer(0, "Rolex", "Switzerland", List.of(watch1, watch));

        OrderItem orderItem = new OrderItem(0, watch, 2);
        OrderItem orderItem1 = new OrderItem(0, watch1, 2);

        Customer john = new Customer(0, "John", "4141 4245 4587 6668");

        Order order = new Order(0, LocalDate.now(), 0.1, john,
                List.of(orderItem, orderItem1));

        orderItem.setOrder(order);
        orderItem1.setOrder(order);

        watch.setProducer(producer);
        watch1.setProducer(producer);

       producerService.add(producer);
        Watch watchId1 = watchService.findById(1);
        Watch watchId2 = watchService.findById(2);

        orderItem.setWatch(watchId1);
        orderItem1.setWatch(watchId2);

        customerService.add(john);
        Customer customer = customerService.findById(1);
        order.setCustomer(customer);
        orderService.add(order);

      watchService.showByBrand(Type.ELECTRONIC);
      watchService.showInfoWatch(3000, Type.MECHANICAL);
      producerService.showWatchByCountry("Switzerland");
      producerService.showSumByPrice(10000);

    }
}

