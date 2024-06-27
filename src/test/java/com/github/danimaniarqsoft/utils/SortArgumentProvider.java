package com.github.danimaniarqsoft.utils;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

public class SortArgumentProvider implements ArgumentsProvider {

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        return Stream.of(
                Arguments.of(new int[] { 2, 8, 5, 3, 9 }, new int[] { 2, 3, 5, 8, 9 }),
                Arguments.of(new int[] { 1, 5, 3, 2, 7 }, new int[] { 1, 2, 3, 5, 7 }));
    }

}
