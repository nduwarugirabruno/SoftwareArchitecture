package io.ahp.tp.service;

import io.ahp.tp.entity.Path;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AhpService {
    ResponseEntity<String> getConsistencyRatio(double[][] criteriaMatrix);
    ResponseEntity<List<Path>> getSynthesis(List<Path> criteriaValues, double[][] criteriaMatrix);
}
