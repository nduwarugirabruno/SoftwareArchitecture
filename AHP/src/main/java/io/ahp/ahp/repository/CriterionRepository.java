package io.ahp.ahp.repository;

import io.ahp.ahp.entity.Criterion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CriterionRepository extends JpaRepository<Criterion, UUID> {

    @Query("select c from criterion c where c.name like %?1%")
    List<Criterion> findByName(String name);

    @Query("select c from criterion c where c.weight = ?1")
    List<Criterion> findByWeight(String weight);

    @Query("select c from criterion c where c.goal.name like %?1%")
    List<Criterion> findByGoal_Name(String name);

}
