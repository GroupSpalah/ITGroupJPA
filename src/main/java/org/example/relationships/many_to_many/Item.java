package org.example.relationships.many_to_many;

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
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "item_id")
    int id;

    String name;
}
