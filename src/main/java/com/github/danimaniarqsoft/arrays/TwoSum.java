package com.github.danimaniarqsoft.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TwoSum {

    public List<int[]> process(int[] nums, int target) {
        List<int[]> pairs = new ArrayList<>();

        if (nums == null || nums.length < 2) {
            return new ArrayList<>();
        }

        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (maps.get(diff) == null) {
                maps.put(nums[i], i);
            } else {
                pairs.add(new int[] { i, maps.get(diff) });
            }
        }

        return pairs;
    }
}
