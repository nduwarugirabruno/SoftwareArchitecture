package io.ahp.ahp.repository;

import io.ahp.ahp.entity.CriteriaValues;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CriteriaValuesRepository extends JpaRepository<CriteriaValues, UUID> {

    @Query("select c from criteria_values c where c.datas like %?1%")
    List<CriteriaValues> findByData(String data);

}
