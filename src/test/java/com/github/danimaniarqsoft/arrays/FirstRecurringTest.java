package com.github.danimaniarqsoft.arrays;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.github.danimaniarqsoft.FirstRecurringCharacter;
import com.github.danimaniarqsoft.utils.StringArrayConverter;

class FirstRecurringTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/firstRecurring.csv", numLinesToSkip = 1)
    void firstRecurring(
            @ConvertWith(StringArrayConverter.class) int[] input,
            int expected) {
        int result = new FirstRecurringCharacter().firstRecurringCharacter(input);
        assertEquals(expected, result);
    }
}
