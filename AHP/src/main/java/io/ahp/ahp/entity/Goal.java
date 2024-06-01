package io.ahp.ahp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;


// Entité Goal
@Entity(name = "goal")
@Table(name = "goal")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goal {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    public Goal(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\n\tGoal ->" +
                "\n\t\tid: " + id +
                "\n\t\tname: " + name;
    }
}
