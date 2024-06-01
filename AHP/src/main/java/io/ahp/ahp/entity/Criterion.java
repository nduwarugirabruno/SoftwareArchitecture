package io.ahp.ahp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

// Entité Criterion
@Entity(name = "criterion")
@Table(name = "criterion")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Criterion {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "weight", nullable = false)
    private double weight;

    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;

    public Criterion(String name, double weight, Goal goal) {
        this.name = name;
        this.weight = weight;
        this.goal = goal;
    }

    @Override
    public String toString() {
        return "\n\tCriterion ->" +
                "\n\t\tid: " + id +
                "\n\t\tname: " + name +
                "\n\t\tweight: " + weight +
                "\n\t\tgoal: " + goal;
    }
}
