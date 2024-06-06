package io.ahp.ahp;

import io.ahp.ahp.entity.Criterion;
import io.ahp.ahp.entity.Goal;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootTest
class ApplicationTests {

    private int largeur, longueur, profondeur;

    private final Goal MY_GOAL = new Goal("BEST TIME TABLE EVER");
    private final ArrayList<Criterion> criteria = new ArrayList<>(
            Arrays.asList(
                    new Criterion("Cmax", 4, MY_GOAL),
                    new Criterion("Dequip", 4, MY_GOAL),
                    new Criterion("Dlist", 4, MY_GOAL),
                    new Criterion("Dlect", 4, MY_GOAL)
            )
    );


    @Test
    void contextLoads() {
    }

    @Test
    void firstAnalyticalHierarchicalProcess() {
        largeur = 7;
        longueur = 3;
        profondeur = 4;

        // weights = {2.419620658, 0.8288522034, 0.5849533987, 0.3054826721};
        double[] weights = {2.419620658, 0.8288522034, 0.5849533987, 0.3054826721};
        double[][][] criteriaValues = {
                { // Lundi
                        {100, 1, 1, 1}, // Matinée
                        {60, 0, 0, 1}, // Après-midi
                        {70, 1, 1, 0}  // Soir
                }, { // Mardi
                        {70, 0, 0, 0}, // Matinée
                        {50, 1, 0, 1}, // Après-midi
                        {40, 1, 1, 0}  // Soir
                }, { // Mercredi
                        {40, 0, 1, 1}, // Matinée
                        {60, 1, 1, 1}, // Après-midi
                        {90, 0, 1, 0}  // Soir
                }, { // Jeudi
                        {40, 0, 1, 1}, // Matinée
                        {100, 1, 0, 1}, // Après-midi
                        {50, 1, 0, 0}  // Soir
                }, { // Vendredi
                        {50, 1, 1, 0}, // Matinée
                        {30, 0, 0, 1}, // Après-midi
                        {40, 0, 1, 1}  // Soir
                }, { // Samedi
                        {50, 0, 1, 1}, // Matinée
                        {20, 1, 1, 1}, // Après-midi
                        {70, 1, 0, 0}  // Soir
                }, { // Dimanche
                        {90, 1, 1, 1}, // Matinée
                        {60, 1, 0, 0}, // Après-midi
                        {50, 1, 0, 0}  // Soir
                }
        };

        for (double[][] criteriaValue : criteriaValues)
            for (double[] criteria : criteriaValue) System.out.println(Arrays.toString(criteria));

        for (int i = 0; i < criteriaValues.length; i++) {
            System.out.println("Slice " + i + ":");
            for (int j = 0; j < criteriaValues[i].length; j++) {
                System.out.print("  Row " + j + ": [");
                for (int k = 0; k < criteriaValues[i][j].length; k++) {
                    System.out.printf("%.1f", criteriaValues[i][j][k]);
                    if (k < criteriaValues[i][j].length - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println("]");
            }
            System.out.println();
        }
        System.out.println("Lundi, la matinée : " + criteriaValues[0][0][0] + ", l'aprèm : " + criteriaValues[0][1][0] + ", le soir : " + criteriaValues[0][2][0]);
        // Calcul des scores et détermination des meilleurs créneaux horaires
        double[][][] scores = new double[largeur][longueur][profondeur];

        // Calcul des scores
        for (int day = 0; day < criteriaValues.length; day++) {
            for (int period = 0; period < criteriaValues[day].length; period++) {
                double score = 0;
                for (int criterion = 0; criterion < criteriaValues[day][period].length; criterion++) {
                    score += criteriaValues[day][period][criterion] * weights[criterion];
                }
                scores[day][period][0] = score;
            }
        }

        // Affichage des scores pour chaque jour et période
        String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};
        String[] periods = {"Matinée", "Après-midi", "Soir"};

        for (int day = 0; day < scores.length; day++) {
            System.out.println(days[day] + ":");
            for (int period = 0; period < scores[day].length; period++) {
                System.out.println("  " + periods[period] + ": Score = " + scores[day][period][0]);
            }
        }
    }

    @Test
    void firstAnalyticalHierarchicalProcessRev() {
    }
}
