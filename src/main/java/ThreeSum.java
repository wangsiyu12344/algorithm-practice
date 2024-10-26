package main.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Integer ri = null;
        Integer rj = null;
        for (int i = 0; i < nums.length - 2; i++) {
            if (ri != null && nums[i] == ri) {
                continue;
            }
            for (int j = i+1; j < nums.length - 1; j++) {
                if (rj != null && nums[j] == rj) {
                    continue;
                }
                for (int k = j+1; k < nums.length; k++) {
                    List<Integer> subResult = new ArrayList<>();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        subResult.add(nums[i]);
                        subResult.add(nums[j]);
                        subResult.add(nums[k]);
                        result.add(subResult);
                        ri = nums[i];
                        rj = nums[j];
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        threeSum.threeSum(new int[] {0,0,0,0,0});
    }
}
