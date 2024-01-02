package org.example.homeworks.anton.hw_22_12_23.domain;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString
public class Purchase {
    @Id
    @GeneratedValue
    @Column(name = "purchase_id")
    int id;

    LocalDate date;

    @ManyToOne
    @JoinColumn(name = "FK_Purchase_Buyer")
    Buyer buyer;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            mappedBy = "purchase")
    List<OrderItema> orderItems;
}
