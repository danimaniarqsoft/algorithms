package com.github.danimaniarqsoft.hashtables;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    public int process(int[] array) {
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer[] pair = map.get(array[i]);
            if (pair == null) {
                map.put(array[i], new Integer[] { 1, i });
            } else {
                pair[0] = pair[0] + 1; // count
                pair[1] = i; // last index
                map.put(array[i], pair);
            }
        }

        Integer currentMaxValue = null;
        Integer[] currentMax = null;

        for (Map.Entry<Integer, Integer[]> entry : map.entrySet()) {

            if (entry.getValue()[0] > 1
                    && (currentMax == null || (entry.getValue()[0] > currentMax[0])
                            || (entry.getValue()[0] == currentMax[0]
                                    && entry.getValue()[1] < currentMax[1]))) {
                currentMax = entry.getValue();
                currentMaxValue = entry.getKey();

            }
        }

        if (currentMax == null) {
            return -1;
        } else {
            return currentMaxValue;
        }
    }

}
