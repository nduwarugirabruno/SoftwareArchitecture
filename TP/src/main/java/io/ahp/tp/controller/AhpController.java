package io.ahp.tp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.ahp.tp.entity.Path;
import io.ahp.tp.service.AhpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

        try {
            List<double[]> list = objectMapper.readValue(criteriaMatrix, List.class);
            System.out.println("mat -> " + list + "\nlist 0 -> " + Arrays.toString(list.toArray(new double[4][4])[0]));
            System.out.println("00 -> ");
            int rows = list.size();
            System.out.println("01 -> rows " + rows);
            int cols = list.get(1).length;
            System.out.println("02 -> cols " + cols);
            double[][] matrix = new double[rows][cols];

            for (int i = 0; i < rows; i++) {
                matrix[i] = list.get(i);
            }

            System.out.println("matrix -> " + Arrays.deepToString(matrix));
            return ahpService.getSynthesis(criteriaValues, matrix);
        } catch (JsonProcessingException e) {
            System.out.println("Error Cause -> " + e.getCause());
            System.out.println("Error Message -> " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie un code de statut 500
        }
    }
}