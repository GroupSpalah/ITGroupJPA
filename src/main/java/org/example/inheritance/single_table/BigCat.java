package org.example.inheritance.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@DiscriminatorValue(value = "big_cat")
public class BigCat extends Cat {
    boolean isTail;
}
