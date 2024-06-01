package io.ahp.tp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entité Alternative
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;
    private boolean hasAVEquipment;
    private boolean isAvailableForStudent;
    private boolean isAvailableForTeacher;
    @ManyToOne
    private Goal goal;

    public <U> U getPriorityScore() {
        return null;
    }
}
