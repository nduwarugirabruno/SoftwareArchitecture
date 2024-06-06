package io.ahp.ahp.utils;

import io.ahp.ahp.entity.*;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;


// Service pour le calcul AHP et la création de l'emploi du temps
@Service
public class AHPScheduler {

    public void createSchedule(Course course, Goal goal, List<Criterion> criterionList, CriteriaValues criteriaValues) {
        // Créer les instances des entités
        Criterion capacity = new Criterion("Maximum classroom capacity", 2, goal);
        Criterion avEquipment = new Criterion("Availability of audiovisual equipment in classrooms", 3, goal);
        Criterion studentAvailability = new Criterion("Availability of students for certain time slots", 2, goal);
        Criterion teacherAvailability = new Criterion("Availability of teachers for certain time slots", 1, goal);

        // Effectuer les comparaisons par paires et calculer les priorités
        // ...

        // Créer les alternatives (salles de classe)
        List<Classroom> classrooms = createClassrooms(goal);

        // Classer les alternatives en fonction des priorités globales
        List<Classroom> sortedClassrooms = classrooms.stream()
                .sorted(Comparator.comparing(Classroom::getCapacity))
                .toList();

        // Créer l'emploi du temps
        createTimeSlots(course, sortedClassrooms);
    }

    private List<Classroom> createClassrooms(Goal goal) {
        // Logique pour créer les instances de Classroom
        // ...
        return List.of();
    }

    private void createTimeSlots(Course course, List<Classroom> sortedClassrooms) {
        // Logique pour créer les instances de TimeSlot en attribuant les salles de classe
        // ...
    }

    private double[][][] calculateCriteraValue() {
        return null;
    }
}