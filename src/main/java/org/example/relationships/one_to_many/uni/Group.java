package org.example.relationships.one_to_many.uni;

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
@Table(name = "SGroup")
public class Group {
    @Id
    @GeneratedValue
    @Column(name = "group_id")
    int id;

    String name;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},
            fetch = FetchType.LAZY)
    /*@JoinTable(name = "group_student", joinColumns = @JoinColumn(name = "FK_Student"),
    inverseJoinColumns = @JoinColumn(name = "FK_Group"))*/
    @JoinColumn(name = "FK_Student_Group", referencedColumnName = "group_id")
    List<Student> students;
}
