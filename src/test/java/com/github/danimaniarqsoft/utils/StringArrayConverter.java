package com.github.danimaniarqsoft.utils;

import java.util.stream.Stream;

import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;

public class StringArrayConverter extends SimpleArgumentConverter {
    @Override
    protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
        if (source instanceof String && int[].class.isAssignableFrom(targetType)) {
            return Stream.of(((String) source).split("\\s*,\\s*")).mapToInt(s -> {
                try {

                    return Integer.parseInt(s);

                } catch (Exception e) {
                    return 0;
                }

            }).toArray();
        } else {
            throw new IllegalArgumentException("Conversion from " + source.getClass() + " to "
                    + targetType + " not supported.");
        }
    }
}
