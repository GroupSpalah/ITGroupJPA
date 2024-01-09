package org.example.inheritance.mapped_super_class;

import jakarta.persistence.MappedSuperclass;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
@MappedSuperclass
public abstract class Dog {
    String name;
}
