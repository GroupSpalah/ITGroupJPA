package org.example.homeworks.misha.hw_15_12_23.domain;

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
public class Producer {
    @Id
    @GeneratedValue
    @Column(name = "producer_id")
    int id;

    String name;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
    mappedBy = "producer")

    Notebook notebook;
}
