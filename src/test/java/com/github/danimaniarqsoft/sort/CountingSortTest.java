package com.github.danimaniarqsoft.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.sorting.CountingSort;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

class CountingSortTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void heapify(
            @ConvertWith(StringArrayConverter.class) int[] input,
            @ConvertWith(StringArrayConverter.class) int[] expected) {
        new CountingSort().sort(input);
        assertArrayEquals(expected, input);
    }

}
