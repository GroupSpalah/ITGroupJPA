package org.example.homeworks.anton.hw_22_12_23.domain;

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
public class OrderItema {
    @Id
    @GeneratedValue
    @Column(name = "orderItem_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "FK_OrderItem_Purchase")
    Purchase purchase;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_OrderItem_Watch")
   WatchA watchA;
     int count;
}
