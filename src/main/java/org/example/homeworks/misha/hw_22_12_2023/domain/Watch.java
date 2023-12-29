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
public class Watch {
    @Id
    @GeneratedValue
    @Column(name = "watch_id")
    int id;

    String brand;

    @Enumerated(EnumType.STRING)
    Type type;

    int price;

    @ManyToOne
    @JoinColumn(name = "FK_Watch_Producer")
    Producer producer;

    public Watch(int id, String brand, Type type, int price) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }
}
