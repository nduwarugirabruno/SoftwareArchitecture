package io.ahp.ahp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

// Entité Classroom
@Entity(name = "classroom")
@Table(name = "classroom")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "hasAVEquipment", nullable = false)
    private boolean hasAVEquipment;

    @Column(name = "is_available_for_student", nullable = false)
    private boolean isAvailableForStudent;

    @Column(name = "is_available_for_teacher", nullable = false)
    private boolean isAvailableForTeacher;

    @Override
    public String toString() {
        return "\n\tClassroom ->" +
                "\n\t\tid: " + id +
                "\n\t\tname: " + name +
                "\n\t\tcapacity: " + capacity +
                "\n\t\thasAVEquipment: " + hasAVEquipment +
                "\n\t\tisAvailableForStudent: " + isAvailableForStudent +
                "\n\t\tisAvailableForTeacher: " + isAvailableForTeacher;
    }
}
