package org.example.inheritance.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
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
@DiscriminatorValue(value = "small_cat")
public class SmallCat extends Cat {
    int size;
}
