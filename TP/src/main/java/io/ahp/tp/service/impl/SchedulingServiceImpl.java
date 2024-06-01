package io.ahp.tp.service.impl;

import io.ahp.tp.entity.Classroom;
import io.ahp.tp.entity.Course;
import io.ahp.tp.entity.Criterion;
import io.ahp.tp.entity.Goal;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


// Service pour le calcul AHP et la création de l'emploi du temps
@Service
public class SchedulingServiceImpl {

    public void createSchedule(Course course) {
        // Créer les instances des entités
        Goal goal = new Goal("Créer un emploi du temps pour le cours " + course.getName() + " sur une semaine");
        Criterion capacity = new Criterion("Maximum classroom capacity", goal);
        Criterion avEquipment = new Criterion("Availability of audiovisual equipment in classrooms", goal);
        Criterion studentAvailability = new Criterion("Availability of students for certain time slots", goal);
        Criterion teacherAvailability = new Criterion("Availability of teachers for certain time slots", goal);

        // Effectuer les comparaisons par paires et calculer les priorités
        // ...

        // Créer les alternatives (salles de classe)
        List<Classroom> classrooms = createClassrooms(goal);

        // Classer les alternatives en fonction des priorités globales
        List<Classroom> sortedClassrooms = classrooms.stream()
                .sorted(Comparator.comparing(Classroom::getPriorityScore))
                .collect(Collectors.toList());

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
}