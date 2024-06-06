package io.ahp.ahp.repository;

import io.ahp.ahp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {

    @Query("select c from course c where c.name like %?1%")
    List<Course> findByName(String name);
}
