package io.ahp.ahp.repository;

import io.ahp.ahp.entity.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, UUID> {

    @Query("select c from time_slot c where string(c.dayOfWeek) = ?1")
    List<TimeSlot> findByName(String name);

}
