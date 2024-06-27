package com.github.danimaniarqsoft;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

class ShowcaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/sum_data.csv", numLinesToSkip = 1)
    void sum(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

    @ParameterizedTest
    @MethodSource("dataProvider")
    void sumFromMethodSource(int a, int b, int sum) {
        assertEquals(sum, a + b);
    }

    private static Stream<Arguments> dataProvider() {
        return Stream.of(
                Arguments.of(2, 3, 5),
                Arguments.of(10, 10, 20));
    }
}
