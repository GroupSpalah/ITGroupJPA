package org.example.homeworks.misha.hw_22_12_2023.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orderItem_id")
    int id;

    @OneToOne
    @JoinColumn(name = "FK_OrderItem_Watch")
    Watch watch;

    int count;

    @ManyToOne
    @JoinColumn(name = "FK_OrderItem_Order")
    Order order;

    public OrderItem(int id, Watch watch, int count) {
        this.id = id;
        this.watch = watch;
        this.count = count;
    }
}
