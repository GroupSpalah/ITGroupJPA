package org.example.homeworks.anton.hw_15_12_23.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class Notebook {
     @Id
     @GeneratedValue
     @Column(name = "notebook_id")
     int id;
    String model;
    String manufacturer;
    String date;
    int ram;
    int ssd;
    String cpu;
}
