package com.github.danimaniarqsoft.sort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.sorting.HeapSort;
import com.github.danimaniarqsoft.utils.ArrayPrint;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

class HeapSortTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void heapify(
            @ConvertWith(StringArrayConverter.class) int[] input,
            @ConvertWith(StringArrayConverter.class) int[] expected) {
        new HeapSort().sort(input);
        ArrayPrint.print(input);
        assertArrayEquals(expected, input);
    }
}
