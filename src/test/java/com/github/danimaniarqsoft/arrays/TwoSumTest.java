package com.github.danimaniarqsoft.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.TwoSum;
import com.github.danimaniarqsoft.utils.ArrayPrint;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

class TwoSumTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sum.csv", numLinesToSkip = 1)
    void twoSum(
            @ConvertWith(StringArrayConverter.class) int[] input,
            int target,
            @ConvertWith(StringArrayConverter.class) int[] expected) {
        int[] result = new TwoSum().twoSum(input, target);
        ArrayPrint.print(result);
        assertArrayEquals(expected, result);
    }
}
