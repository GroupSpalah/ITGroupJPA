package org.example.relationships.one_to_one.bi;

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
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "person_id")
    int id;

    String name;

    int age;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "person")
    Address address;
}
