package io.ahp.ahp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

// Entité Course
@Entity(name = "course")
@Table(name = "course")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Override
    public String toString() {
        return "\n\tCourse ->" +
                "\n\t\tid: " + id +
                "\n\t\tname: " + name;
    }
}
