package com.github.danimaniarqsoft;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.sorting.QuickSort;
import com.github.danimaniarqsoft.sorting.SelectionSort;
import com.github.danimaniarqsoft.utils.ArrayPrint;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

import static org.junit.Assert.assertArrayEquals;

class SortingTest {

  @ParameterizedTest
  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
  void selectionSort(
      @ConvertWith(StringArrayConverter.class) int[] input,
      @ConvertWith(StringArrayConverter.class) int[] expected) {
    new SelectionSort().sort(input);
    assertArrayEquals(expected, input);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
  void quickSort(
      @ConvertWith(StringArrayConverter.class) int[] input,
      @ConvertWith(StringArrayConverter.class) int[] expected) {
    new QuickSort().sort(input);
    ArrayPrint.print(input);
    assertArrayEquals(expected, input);
  }

}