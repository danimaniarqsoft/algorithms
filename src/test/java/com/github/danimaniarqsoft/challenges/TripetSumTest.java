package com.github.danimaniarqsoft.challenges;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.utils.ListOfArrayConverter;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

public class TripetSumTest {

    private final TripletSum tripletSum = new TripletSum();

    @ParameterizedTest(name = "Nums: {0}, Target: {1} -> Expected: {2}")
    @CsvFileSource(resources = "/triplet-sum.csv", numLinesToSkip = 1)
    @DisplayName("Tests for the tripletSum challenge with various scenarios")
    void testTriplets(@ConvertWith(StringArrayConverter.class) int[] input,
            @ConvertWith(ListOfArrayConverter.class) List<int[]> expected) {

        List<int[]> triplets = tripletSum.solution(input);

        assertEquals(triplets.size(), expected.size(),
                "The number of unique triplets found does not match the expected number.");

        for (int[] triplet : triplets) {
            Arrays.sort(triplet);
        }

        for (int[] tripletExpected : expected) {
            Arrays.sort(tripletExpected);
        }

        for (int[] tripletExpected : expected) {
            boolean isInList = false;
            for (int[] triplet : triplets) {
                if (Arrays.equals(tripletExpected, triplet)) {
                    isInList = true;
                    break;
                }
            }

            assertTrue(isInList, "The expected values are not present");
        }

    }
}
