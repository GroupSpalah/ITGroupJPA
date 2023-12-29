package org.example.homeworks.anton.hw_22_12_23.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.relationships.one_to_many.bi.Apple;
import org.example.relationships.one_to_many.bi.Tree;

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

    @ManyToOne
    @JoinColumn(name = "FK_Order_Buyer")
    Buyer buyer;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "order")
    List<OrderItem> orderItems;
}
