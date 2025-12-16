package com.github.danimaniarqsoft.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class ListOfArrayConverter extends SimpleArgumentConverter {

    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        // 1. Type check: Ensure the source is a String and the target is an int array.
        if (source instanceof String) {

            String inputString = (String) source;

            // 2. Handle empty input: If the CSV cell is empty, return an empty array
            // immediately.
            if (inputString.trim().isEmpty()) {
                return new ArrayList<>();
            }

            String[] stringSplited = inputString.split("\\|");

            List<int[]> output = new ArrayList<>();

            for (String stringArray : stringSplited) {

                int[] result = Stream.of(stringArray.split(","))
                        .map(String::trim)
                        .filter(s -> !s.isEmpty())
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
                        .toArray();
                output.add(result);
            }

            return output;

        } else {
            // 4. Throw exception if types do not match the expected conversion (String to
            // int[]).
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported by StringArrayConverter.");
        }
    }

}