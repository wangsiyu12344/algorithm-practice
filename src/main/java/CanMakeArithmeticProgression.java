package main.java;

import java.util.HashSet;
import java.util.Set;

public class CanMakeArithmeticProgression {

    public boolean canMakeArithmeticProgression(int[] arr) {
        if (arr.length == 2) return true;

        int max = arr[0];
        int min = arr[0];
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            } else if (arr[i] < min) {
                min = arr[i];
            }
            set.add(arr[i]);
        }
        if ((max - min) % (arr.length - 1) != 0) return false;

        int d = ((max - min) / (arr.length - 1));

        int num = min;
        for (int i = 0; i < arr.length; i++) {
            num = min + d * i;
            if (!set.contains(num)) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        CanMakeArithmeticProgression solution = new CanMakeArithmeticProgression();
        System.out.println("The result is:" + solution.canMakeArithmeticProgression(new int[] {0, 0, 1}));
    }
}
