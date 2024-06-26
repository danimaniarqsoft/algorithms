package com.github.danimaniarqsoft.sort;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.sorting.MergeSort;
import com.github.danimaniarqsoft.sorting.QuickSort;
import com.github.danimaniarqsoft.sorting.SelectionSort;
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
    assertArrayEquals(expected, input);
  }

  @ParameterizedTest
  @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
  void mergeSort(
      @ConvertWith(StringArrayConverter.class) int[] input,
      @ConvertWith(StringArrayConverter.class) int[] expected) {
    new MergeSort().sort(input);
    assertArrayEquals(expected, input);
  }

}