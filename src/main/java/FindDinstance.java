package main.java;

import java.util.Arrays;

/**
 * 1385.時間複雑度；nlogm　+ nlogn
 */
public class FindDinstance {

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int result = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (!binarySearch(arr1[i], arr2, d)) {
                result++;
            }
        }
        return result;
    }

    public boolean binarySearch(int number, int[]arr2, int d) {
        int left = 0;
        int right = arr2.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arr2[mid] <= d + number && arr2[mid] >= number - d) {
                return true;
            } else if (arr2[mid] > d + number) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindDinstance solution = new FindDinstance();
        System.out.println(solution.findTheDistanceValue(new int[] {1,4,2,3}, new int[] {-4, -3, 6, 10, 20, 30}, 3));
    }
}
