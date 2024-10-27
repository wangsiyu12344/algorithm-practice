package main.java;

import java.util.Arrays;

/**
 * 2300.時間複雑度 時間複雑度；nlogm　+ nlogn
 */
public class SucessfulPairsOfSpellsAndPotions {

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] result = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int startIndex = findStartIndex(spells[i], potions, success);
            result[i] = potions.length - startIndex;
        }
        return result;
    }

    public int findStartIndex(int spell, int[] potions, long success) {
        int left = 0;
        int right = potions.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long)spell * potions[mid] < success) {
                left = mid + 1;  // [0,left]肯定小于success，所以舍去
            } else {
                right = mid - 1; // [mid,right]大于等于success，所以舍去
            }
        }
        return left;
    }
}
