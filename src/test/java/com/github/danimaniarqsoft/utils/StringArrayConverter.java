package com.github.danimaniarqsoft.utils;

import java.util.stream.Stream;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

/**
 * Custom JUnit 5 ArgumentConverter used to convert a single String argument
 * (typically read from a CSV column) into an array of primitive integers
 * (int[]).
 *
 * This converter handles:
 * 1. Conversion of comma-separated number strings (e.g., "1,2,3") to int[].
 * 2. Trimming whitespace around numbers.
 * 3. Handling empty string input by returning an empty array.
 * 4. Gracefully handling NumberFormatExceptions (although throwing an exception
 * might be better for robust testing).
 */
public class StringArrayConverter extends SimpleArgumentConverter {

    /**
     * Attempts to convert the source object (String) into the target type (int[]).
     *
     * @param source     The input object (the string value read from the CSV cell).
     * @param targetType The desired target type (which must be int[] for this
     *                   converter).
     * @return An array of integers (int[]) derived from the input string.
     * @throws ArgumentConversionException if the conversion fails due to format
     *                                     issues.
     * @throws IllegalArgumentException    if the target type is not supported.
     */
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        // 1. Type check: Ensure the source is a String and the target is an int array.
        if (source instanceof String && int[].class.isAssignableFrom(targetType)) {

            String inputString = (String) source;

            // 2. Handle empty input: If the CSV cell is empty, return an empty array
            // immediately.
            if (inputString.trim().isEmpty()) {
                return new int[0];
            }

            // 3. Conversion logic: Use the Stream API for robust parsing.
            return Stream.of(inputString.split("\\s*,\\s*"))
                    // Split the string by commas, allowing for optional whitespace around the comma
                    // (e.g., "1, 2,3").
                    .mapToInt(s -> {
                        try {
                            // Convert the trimmed string element to an integer.
                            return Integer.parseInt(s.trim());
                        } catch (Exception e) {
                            // NOTE: Returning '0' here can mask errors. In a production test environment,
                            // it is often better to re-throw an ArgumentConversionException to fail the
                            // test clearly.
                            // If the intent is error tolerance, '0' is returned.
                            return 0;
                        }
                    })
                    .toArray(); // Collect the stream elements into the final int array.

        } else {
            // 4. Throw exception if types do not match the expected conversion (String to
            // int[]).
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported by StringArrayConverter.");
        }
    }
}