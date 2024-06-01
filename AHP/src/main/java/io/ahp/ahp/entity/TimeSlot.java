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

    @Column(name = "date", nullable = false)
    private String date;

    @Column(name = "start_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", columnDefinition = "TIMESTAMP", nullable = false)
    private LocalDateTime endTime;

    @Override
    public String toString() {
        return "\n\tTimeSlot ->" +
                "\n\t\tid: " + id +
                "\n\t\tdate: " + date +
                "\n\t\tstartTime: " + startTime +
                "\n\t\tendTime: " + endTime;
    }
}