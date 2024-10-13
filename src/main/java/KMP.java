package main.java;

/**
 * 時間計算量　O(m + n)
 * ビデオ：https://www.bilibili.com/video/BV19Q4y1c7ko/?vd_source=1e46a237c6d2a92831dadcb5d2a9baac
 */

public class KMP {

    private static int isSubstring(String str, String subStr) {
        // subStr が空であれるあるいはstr の長さが subStr より短い場合であれば、-1を返す
        if (subStr.isEmpty() || str.length() < subStr.length()) return -1;
        //

        // subStr に基づいて next 配列を取得する
        int[] next = getNext(subStr);
        int i = 0; // str のインデックス
        int j = 0; // subStr のインデックス

        // str を走査するループ
        while (i < str.length() && j < subStr.length()) {
            // 文字が一致する場合
            if (str.charAt(i) == subStr.charAt(j)) {
                i++; // str のインデックスを進める
                j++; // subStr のインデックスを進める
            } else if (j == 0) {
                // 一致しない場合
                i++;
            } else {
                // 一致しない場合
                j = next[j];
            }
        }

        // subStr の全長に達したか確認する
        if (j == subStr.length()) {
            return i - j; // マッチが見つかった
        }
        return -1; // マッチが見つからなかった
    }

    private static int[] getNext(String subStr) {
        if (subStr.length() == 1) {
            return new int[]{-1};
        }
        int[] next = new int[subStr.length()]; // next 配列を初期化
        next[0] = -1; //意味がないため、-1にします。
        next[1] = 0; // 単一の文字は前接しない
        int i = 2;
        int k = i - 1;
        while (i < subStr.length()) {
            if (next[k] >= 0 && subStr.charAt(i) == subStr.charAt(next[k])) {
                next[i] = next[k] + 1;
                i++;
                k = i - 1;
            } else if (k > 0) {
                k = next[k];
            } else {
                next[i] = 0;
                i++;
                k = i - 1;
            }
        }
        return next; // next 配列を返す
    }


    public static void main(String[] args) {
        System.out.println("substring start index: " + KMP.isSubstring("abatabasabatabatsf", "abatabasabatabats"));
    }
}
