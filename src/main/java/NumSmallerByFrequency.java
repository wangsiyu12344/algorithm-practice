package main.java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumSmallerByFrequency {

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] transQueries = transfer(queries);
        int[] transWords = transfer(words);
        Arrays.sort(transWords);
        int[] result = new int[queries.length];
        for (int i = 0; i < transQueries.length; i++) {
            int startIndex = findStartIndex(transWords, transQueries[i] + 1);
            result[i] = transWords.length - startIndex;
        }
        return result;
    }

    public int findStartIndex(int[] arrays, int targetNum) {
        int left = 0;
        int right = arrays.length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (arrays[mid] < targetNum) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    public int[] transfer(String[] arrays) {
        int[] transferArrays = new int[arrays.length];
        for (int i = 0; i < arrays.length; i++) {
            char smallest = 'z';
            Map<Character, Integer> charCountMap = new HashMap<>();
            for (int j = 0; j < arrays[i].length();j++) {
                char ch = arrays[i].charAt(j);
                if (smallest > ch) {
                    smallest = ch;
                }
                charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
            }
            transferArrays[i] = charCountMap.get(smallest);
        }
        return transferArrays;
    }

    public static void main(String[] args) {
        NumSmallerByFrequency solution = new NumSmallerByFrequency();
        solution.numSmallerByFrequency(new String[]{"bba","abaaaaaa","aaaaaa","bbabbabaab","aba","aa","baab","bbbbbb","aab","bbabbaabb"}, new String[]{"aaabbb","aab","babbab","babbbb","b","bbbbbbbbab","a","bbbbbbbbbb","baaabbaab","aa"});
    }
}
