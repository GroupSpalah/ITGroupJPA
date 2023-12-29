package org.example.homeworks.anton.hw_22_12_23.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.example.relationships.one_to_many.bi.Tree;
import org.example.relationships.one_to_one.bi.Person;

import static jakarta.persistence.CascadeType.PERSIST;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class OrderItem {
    @Id
    @GeneratedValue
    @Column(name = "orderItem_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "FK_OrderItem_Order")
    Order order;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_OrderItem_Watch")
   WatchA watchA;
     int count;
}
