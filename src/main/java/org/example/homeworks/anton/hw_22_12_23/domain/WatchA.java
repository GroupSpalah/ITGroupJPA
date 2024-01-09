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
@ToString(exclude = "manufacturer")
public class WatchA {
    @Id
    @GeneratedValue
    @Column(name = "watch_id")
    int id;

    String model;

    @Enumerated(EnumType.STRING)
    WatchType watchType;

    int price;

    @ManyToOne
    @JoinColumn(name = "FK_Watch_Manufacturer")
    Manufacturer manufacturer;

}
