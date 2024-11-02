package main.java;

public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = 0;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
        }
        int left = 1;
        int right = max;
        int ans = threshold;
        while (left <= right) {
            int mid = left + (right - left) / 2;  //overflowを防ぐため
            int count = countSum(nums, mid);
            if (count <= threshold) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    public int countSum(int[] nums, int mid) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / mid);
        }
        return sum;
    }

    public static void main(String[] args) {
        SmallestDivisor solution = new SmallestDivisor();
        solution.smallestDivisor(new int[] {1,2,5,9}, 6);
    }
}
