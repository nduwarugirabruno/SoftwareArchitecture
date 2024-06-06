package io.ahp.ahp.entity;

import jakarta.persistence.*;

// Entité TimeSlot
@Table(name = "day_of_week")
public enum DayOfWeek {
    LUNDI, MARDI, MERCREDI, JEUDI, VENDREDI, SAMEDI, DIMANCHE
}