package io.ahp.tp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ahp.tp.entity.Path;
import io.ahp.tp.service.AhpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AhpController {

    final
    AhpService ahpService;

    final
    ObjectMapper objectMapper;

    @Autowired
    public AhpController(AhpService ahpService, ObjectMapper objectMapper) {
        this.ahpService = ahpService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/consistency-ratio")
    public ResponseEntity<String> getConsistencyRatio2(@RequestBody double[][] matrix) {
        return ahpService.getConsistencyRatio(matrix);
    }

    @PostMapping("/get-synthesis")
    public ResponseEntity<List<Path>> getSynthesis(@RequestParam String criteriaMatrix, @RequestBody List<Path> criteriaValues) {

//        String[] rows = criteriaMatrix.replaceAll("\\[|\\]", "").split("\\],\\[");
//        double[][] matrix = new double[rows.length][rows[0].split(",").length];
//
//        for (int i = 0; i < rows.length; i++) {
//            String[] values = rows[i].split(",");
//            for (int j = 0; j < values.length; j++) {
//                matrix[i][j] = Double.parseDouble(values[j]);
//            }
//        }

        try {
            List<double[]> cars1 = objectMapper.readValue(criteriaMatrix, List.class);
            System.out.println("car: " + Arrays.toString(cars1.toArray()));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

//        try {
//            objectMapper.convertValue(criteriaMatrix, new TypeReference<>() {});
//        } catch (IllegalArgumentException e) {
//            throw new RuntimeException(e);
//        } finally {
//            matrix = objectMapper.convertValue(criteriaMatrix, new TypeReference<>() {});
//        }

        double[][] matrix = new double[0][];

        return ahpService.getSynthesis(criteriaValues, matrix);
    }
}