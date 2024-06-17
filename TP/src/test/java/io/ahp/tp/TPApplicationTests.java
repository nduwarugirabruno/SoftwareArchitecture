package io.ahp.tp;

import io.ahp.tp.entity.Path;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static io.ahp.tp.utils.AHP.*;

@SpringBootTest(classes = TPApplicationTests.class)
class TPApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void ahp() {
        double[][] criteriaMatrix = {
                {1, 3, 5, 7},
                {1.0 / 3, 1, 3, 5},
                {1.0 / 5, 1.0 / 3, 1, 3},
                {1.0 / 7, 1.0 / 5, 1.0 / 3, 1}
        };

        double[][] normalizedMatrix = normalizeMatrix(criteriaMatrix);
        double[] weights = calculateWeights(normalizedMatrix);
        double consistencyRatio = calculateConsistencyRatio(criteriaMatrix, weights);

        System.out.println("Normalized Matrix:");
        for (double[] row : normalizedMatrix) {
            for (double value : row) {
                System.out.printf("|\t%.4f\t", value);
            }
            System.out.println("|");
        }

        System.out.println("\nWeights:");
        for (double weight : weights) {
            System.out.printf("|\t%.4f\t", weight);
        }
        System.out.println("|");

        System.out.println("\n\nConsistency Ratio: " + consistencyRatio);
        if (consistencyRatio < 0.1) {
            System.out.println("The consistency ratio is acceptable.");
        } else {
            System.out.println("The consistency ratio is not acceptable.");
        }
    }

    @Test
    void ahpSort() {

        double[][] criteriaMatrix = {
                {1, 3, 5, 7},
                {1.0 / 3, 1, 3, 5},
                {1.0 / 5, 1.0 / 3, 1, 3},
                {1.0 / 7, 1.0 / 5, 1.0 / 3, 1}
        };

        List<Path> criteriaValues = new ArrayList<>();
        criteriaValues.add(new Path("dla-yde", 210.4, 189.7, 0.3049, 1.0214));
        criteriaValues.add(new Path("dla-ebl", 165.3, 94.8, 0.4646, 1.0214));
        criteriaValues.add(new Path("nga-dsc", 225.4, 189.7, 0.392, 0.5107));

        double[][] normalizedMatrix = normalizeMatrix(criteriaMatrix);
        double[] weights = calculateWeights(normalizedMatrix);
        double consistencyRatio = calculateConsistencyRatio(criteriaMatrix, weights);
        System.out.println("normalized matrix -> " + Arrays.deepToString(normalizedMatrix) + ", consistency ratio -> " + consistencyRatio + ", weights -> " + Arrays.toString(weights));

        List<Path> values = new ArrayList<>();
        if (consistencyRatio < 0.1)
            criteriaValues.forEach(criteriaValue -> values.add(new Path(criteriaValue.getPath(), criteriaValue.getDistance() * weights[0], criteriaValue.getTraffic() * weights[1], criteriaValue.getDuration() * weights[2], criteriaValue.getRoadCondition() * weights[3])));

        values.sort(Comparator.comparingDouble(path -> path.getDistance() + path.getDuration() + path.getTraffic() + path.getRoadCondition()));
        System.out.println(values);
    }


}
