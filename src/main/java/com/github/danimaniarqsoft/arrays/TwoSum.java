package com.github.danimaniarqsoft.arrays;

import java.util.HashMap;

public class TwoSum {

    public int[] process(int[] nums, int target) {
        if (nums.length < 2) {
            return nums;
        }

        HashMap<Integer, Integer> maps = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (maps.get(diff) == null) {
                maps.put(nums[i], i);
            } else {
                return new int[] { i, maps.get(diff) };
            }
        }

        return new int[0];
    }
}
