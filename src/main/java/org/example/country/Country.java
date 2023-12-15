package org.example.country;

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
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    int id;

    @Column(length = 30)
    String name;

    int age;

    @Enumerated(EnumType.STRING)
    State state;
}
