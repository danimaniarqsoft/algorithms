package com.github.danimaniarqsoft.challenges.binarysearch;

/**
 * Solution for the Wood Cutting challenge (often called 'EKO').
 * This class finds the maximum saw height setting to retrieve at least 'k' wood.
 * * Strategy: Binary Search on the possible height range [0, MaxTreeHeight].
 */
public class WoodCutter {

    /**
     * Finds the highest integer saw height that yields at least k meters of wood.
     * * Time Complexity: O(N * log(M)), where N is the number of trees and M is the max height.
     * Space Complexity: O(1).
     * * @param treeHeights Array of tree heights.
     * @param requiredWood (k) Minimum amount of wood needed.
     * @return The optimal saw height setting.
     */
    public int findMaxHeight(int[] treeHeights, int requiredWood) {
        if (treeHeights == null || treeHeights.length == 0) {
            return 0;
        }

        int minSawHeight = 0;
        int maxSawHeight = findMaxTreeHeight(treeHeights);
        int bestSawHeight = 0;

        

        while (minSawHeight <= maxSawHeight) {
            int midSawHeight = minSawHeight + (maxSawHeight - minSawHeight) / 2;
            long collectedWood = calculateTotalWood(treeHeights, midSawHeight);

            if (collectedWood >= requiredWood) {
                // If we have enough wood, try to raise the saw to cut less (greedy)
                bestSawHeight = midSawHeight;
                minSawHeight = midSawHeight + 1;
            } else {
                // Not enough wood, we must lower the saw to cut more
                maxSawHeight = midSawHeight - 1;
            }
        }

        return bestSawHeight;
    }

    /**
     * Calculates the sum of wood cut from all trees for a given saw height.
     * Uses 'long' for the sum to prevent overflow.
     */
    private long calculateTotalWood(int[] treeHeights, int sawHeight) {
        long totalWood = 0;
        for (int height : treeHeights) {
            if (height > sawHeight) {
                totalWood += (height - sawHeight);
            }
        }
        return totalWood;
    }

    /**
     * Finds the tallest tree in the forest to establish the upper bound.
     */
    private int findMaxTreeHeight(int[] treeHeights) {
        int maxH = 0;
        for (int h : treeHeights) {
            if (h > maxH) {
                maxH = h;
            }
        }
        return maxH;
    }
}