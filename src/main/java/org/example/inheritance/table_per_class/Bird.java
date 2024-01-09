package org.example.inheritance.table_per_class;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Bird {
    @Id
    @GeneratedValue
    @Column(name = "bird_id")
    int id;

    String name;
}
