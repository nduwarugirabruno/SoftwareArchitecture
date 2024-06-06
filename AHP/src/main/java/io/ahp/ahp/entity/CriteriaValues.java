package io.ahp.ahp.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.IOException;
import java.util.UUID;

// Entité Criteria Values
@Entity(name = "criteria_values")
@Table(name = "criteria_values")
@Getter
@Setter
@NoArgsConstructor
public class CriteriaValues {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

/*
     |--------------------|-----------|-------------|------------|-----------|
     |       Cour_i       |           |             |            |           |
     |--------------------|    Cmax   |    Dequip   |    Dlist   |   Dlect   |
     |   Jour   | Periode |           |             |            |           |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Lundi   |  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Mardi   |  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Mercredi|  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Jeudi   |  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Vendredi|  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Samedi  |  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
     |          |  Matin  |     2     |      50     |    1.60    |     13    |
     |  Dimanche|  Aprèm  |     3     |      50     |    1.65    |     13    |
     |          |  Soir   |     4     |      60     |    1.75    |     15    |
     |--------------------|-----------|-------------|------------|-----------|
*/

    @Basic
    @Column(columnDefinition = "TEXT", name = "datas", nullable = false)
    private String datas;

    public void setData(double[][][] datas) {
        try {
            this.datas = new ObjectMapper().writeValueAsString(datas);
        } catch (JsonProcessingException e) {
            System.out.println("Exception cause -> " + e.getCause());
            System.out.println("Exception message -> " + e.getMessage());
        }
    }

    public double[][][] getData() {
        try {
            return new ObjectMapper().readValue(this.datas, double[][][].class);
        } catch (IOException e) {
            System.out.println("Exception cause -> " + e.getCause());
            System.out.println("Exception message -> " + e.getMessage());
            return null;
        }
    }
}