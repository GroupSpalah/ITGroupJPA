package org.example.homeworks.misha.hw_22_12_2023.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    int id;

    String localDate;

    double discount;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "order")
    List<Customer> customers;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "order")
    List<OrderItem> orderItems;
}
