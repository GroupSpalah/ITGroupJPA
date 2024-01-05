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
@ToString(exclude = "person")
public class Address {
    @Id
    @GeneratedValue
    @Column(name = "address_id")
    int id;

    String city;

    String country;

    @OneToOne
    @JoinColumn(name = "FK_Address_Person")
    Person person;
}
