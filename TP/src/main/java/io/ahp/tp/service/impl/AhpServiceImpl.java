package io.ahp.tp.service.impl;

import io.ahp.tp.entity.Path;
import io.ahp.tp.service.AhpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static io.ahp.tp.utils.AHP.*;

@Service
public class AhpServiceImpl implements AhpService {
    /**
     * @param criteriaMatrix
     * @return
     */
    @Override
    public ResponseEntity<String> getConsistencyRatio(double[][] criteriaMatrix) {
        try {
            if (criteriaMatrix == null)
                return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE); // renvoi un code de statut 406 : "Not Acceptable"

            double[][] normalizedMatrix = normalizeMatrix(criteriaMatrix);
            double[] weights = calculateWeights(normalizedMatrix);
            double consistencyRatio = calculateConsistencyRatio(criteriaMatrix, weights);

            System.out.println("consistency ratio -> " + consistencyRatio); // renvoie un code de statut 200
            if (consistencyRatio < 0.1)
                return ResponseEntity.ok(String.valueOf(consistencyRatio));
            else
                return new ResponseEntity<>("We are consistent with our decision-making process hence we can conclude to synthesis", HttpStatus.EXPECTATION_FAILED); // renvoi un code de statut 417 : "Expectation Failed"

        } catch (Exception e) {
            System.out.println("Error Cause -> " + e.getCause());
            System.out.println("Error Message -> " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie un code de statut 500
        }
    }

    /**
     * @param criteriaValues
     * @param criteriaMatrix
     * @return
     */
    @Override
    public ResponseEntity<List<Path>> getSynthesis(List<Path> criteriaValues, double[][] criteriaMatrix) {
        try {
            System.out.println(Arrays.deepToString(criteriaMatrix));
            System.out.println(criteriaValues);

            double[][] normalizedMatrix = normalizeMatrix(criteriaMatrix);
            double[] weights = calculateWeights(normalizedMatrix);
            double consistencyRatio = calculateConsistencyRatio(criteriaMatrix, weights);
            System.out.println("normalized matrix -> " + Arrays.deepToString(normalizedMatrix) + ", consistency ratio -> " + consistencyRatio + ", weights -> " + Arrays.toString(weights));

            List<Path> values = new ArrayList<>();
            if (consistencyRatio < 0.1)
                criteriaValues.forEach(criteriaValue -> {
                    values.add(new Path(criteriaValue.getPath(), criteriaValue.getDistance() * weights[0], criteriaValue.getTraffic() * weights[1], criteriaValue.getDuration() * weights[2], criteriaValue.getRoadCondition() * weights[3]));
                });

            values.sort(Comparator.comparingDouble(path -> path.getDistance() + path.getDuration() + path.getTraffic() + path.getRoadCondition()));

            return ResponseEntity.ok(values); // renvoie un code de statut 200
        } catch (Exception e) {
            System.out.println("Error Cause -> " + e.getCause());
            System.out.println("Error Message -> " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); // renvoie un code de statut 500
        }
    }
}
