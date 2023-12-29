package org.example.homeworks.misha.hw_22_12_2023.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
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

    LocalDate date;

    double discount;

    @ManyToOne
    @JoinColumn(name = "FK_Order_Customer")
    Customer customer;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "order", fetch = FetchType.EAGER)
    List<OrderItem> orderItems;
}
