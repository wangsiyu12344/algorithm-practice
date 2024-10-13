package main.java;

/**
 * 時間計算量　O(n * m)
 */

public class SubStrBruteForce {

    public int findSubStr(String s,  String t) {
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || (s.length() < t.length())) return -1;
        for (int k = 0; k < s.length(); k++) {
            // sをループするポインタ
            int i = k;
            // tをループするポインタ
            int j = 0;
            while (i < s.length() && j < t.length() && (s.charAt(i) == t.charAt(j))) {
                i++;
                j++;
            }
            if (j == t.length()) {
                return i - j;
            }

        }
        return -1;
    }



    public static void main(String[] args) {
        SubStrBruteForce solution = new SubStrBruteForce();
        System.out.println(solution.findSubStr("aaaaaaf", "aaf"));
    }

}
