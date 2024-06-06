package io.ahp.ahp.repository;

import io.ahp.ahp.entity.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {

    @Query("select c from classroom c where c.name like %?1%")
    List<Classroom> findByName(String name);

    @Query("select c from classroom c where c.capacity = ?1")
    List<Classroom> findByCapacity(int capacity);

}
