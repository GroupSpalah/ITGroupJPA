package org.example.relationships.many_to_many;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Orderm {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    int id;

    String name;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "order_item", joinColumns = @JoinColumn(name = "FK_Order"),
    inverseJoinColumns = @JoinColumn(name = "FK_Item"))
    List<Item> items;
}
