package org.example.relationships.one_to_one.uni;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

//@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Phone {
    @Id
    @GeneratedValue
    @Column(name = "phone_id")
    int id;

    String number;
}
