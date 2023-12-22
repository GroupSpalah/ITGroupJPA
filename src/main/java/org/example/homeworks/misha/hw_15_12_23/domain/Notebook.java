package org.example.homeworks.misha.hw_15_12_23.domain;

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
@ToString(exclude = "producer")
public class Notebook {
    @Id
    @GeneratedValue
    @Column(name = "notebook_id")
    int id;

    String model;

    @OneToOne
    @JoinColumn(name = "FK_Notebook_Producer")
    Producer producer;

    String releaseDate;

    int ramAmount;

    int ssdCapacity;

    String cpu;
}
