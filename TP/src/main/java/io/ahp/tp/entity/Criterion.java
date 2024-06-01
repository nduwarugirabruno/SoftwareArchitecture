package io.ahp.tp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entité Criterion
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Criterion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private Goal goal;

    public Criterion(String name, Goal goal) {
        this.name = name;
        this.goal = goal;
    }
}
