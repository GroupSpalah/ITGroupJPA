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
    @Column(name = "orderItema_id")
    int id;

    @ManyToOne
    @JoinColumn(name = "FK_OrderItema_Order")
    Ordera order;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "FK_OrderItema_Watch")
   WatchA watchA;
     int count;
}
