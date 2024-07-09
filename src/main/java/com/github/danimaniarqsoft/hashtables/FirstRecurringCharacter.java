package com.github.danimaniarqsoft.hashtables;

import java.util.HashMap;

public class FirstRecurringCharacter {

    public int process(int[] array) {
        HashMap<Integer, Boolean> map = new HashMap<>();

        for (int value : array) {
            if (map.get(value) != null) {
                return value;
            } else {
                map.put(value, true);
            }
        }

        return -1;

    }

}
