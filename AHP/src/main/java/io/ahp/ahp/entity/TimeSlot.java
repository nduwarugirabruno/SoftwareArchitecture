package io.ahp.ahp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

// Entité TimeSlot
@Entity(name = "time_slot")
@Table(name = "time_slot")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_of_week", nullable = false)
    private DayOfWeek dayOfWeek;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "has_av_equipment", nullable = false)
    private Short hasAVEquipment;

    @Column(name = "is_available_for_student", nullable = false)
    private Short isAvailableForStudent;

    @Column(name = "is_available_for_teacher", nullable = false)
    private Short isAvailableForTeacher;

    @Override
    public String toString() {
        return "\n\tTimeSlot ->" +
                "\n\t\tid: " + id +
                "\n\t\tdayOfWeek: " + dayOfWeek +
                "\n\t\tstartTime: " + startTime +
                "\n\t\tendTime: " + endTime +
                "\n\t\thasAVEquipment: " + hasAVEquipment +
                "\n\t\tisAvailableForStudent: " + isAvailableForStudent +
                "\n\t\tisAvailableForTeacher: " + isAvailableForTeacher;
    }
}