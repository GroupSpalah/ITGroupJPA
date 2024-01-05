package org.example.homeworks.anton.hw_22_12_23.domain;

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
public class Buyer {
    @Id
    @GeneratedValue
    @Column(name = "buyer_id")
    int id;

    String cardNumber;

    String name;

}
