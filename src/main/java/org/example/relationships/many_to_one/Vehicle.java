package org.example.relationships.many_to_one;

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
public class Vehicle {
    @Id
    @GeneratedValue
    @Column(name = "vehicle_id")
    int id;

    String model;

    @ManyToOne
    @JoinColumn(name = "FK_Vehicle_Park")
    Autopark autopark;
}
