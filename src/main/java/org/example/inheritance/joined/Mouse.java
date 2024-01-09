package org.example.inheritance.joined;

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
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "obj_type")
public abstract class Mouse {
    @Id
    @GeneratedValue
    @Column(name = "mouse_id")
    int id;

    String name;
}
