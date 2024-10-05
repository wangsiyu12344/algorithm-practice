package main.java;

public class KMP {

    private boolean isSubstring(String str, String subStr) {
        // subStr が空であれば、常に true を返す
        if (subStr.isEmpty()) return true;
        // str の長さが subStr より短い場合、false を返す
        if (str.length() < subStr.length()) return false;

        // subStr に基づいて next 配列を取得する
        int[] next = getNext(subStr);
        int i = 0; // str のインデックス
        int j = 0; // subStr のインデックス

        // str を走査するループ
        while (i < str.length()) {
            // 文字が一致する場合
            if (str.charAt(i) == subStr.charAt(j)) {
                i++; // str のインデックスを進める
                j++; // subStr のインデックスを進める
            } else {
                // 一致しない場合
                if (j > 0) {
                    // j が 0 より大きい場合、next 配列を使用して j を戻す
                    j = next[j - 1];
                } else {
                    // j が 0 の場合、i を進める
                    i++;
                }
            }
        }

        // subStr の全長に達したか確認する
        if (j == subStr.length()) {
            return true; // マッチが見つかった
        }
        return false; // マッチが見つからなかった
    }

    private static int[] getNext(String subStr) {
        int[] next = new int[subStr.length()]; // next 配列を初期化
        next[0] = 0; // 単一の文字は前接しない
        int i = 0, j = 1; // i はマッチ前接長、j は next 配列のインデックス

        // subStr を走査して next 配列を構築するループ
        while (j < subStr.length()) {
            if (subStr.charAt(i) == subStr.charAt(j)) {
                i++; // 前接長を増やす
                next[j] = i; // next[j] を更新
                j++; // j を進める
            } else {
                // 一致しない場合
                if (i == 0) {
                    next[j] = 0; // 現在の文字には前接がない
                    j++; // j を進める
                } else {
                    // i を next[i - 1] に戻す
                    i = next[i - 1];
                }
            }
        }
        return next; // next 配列を返す
    }


    public static void main(String[] args) {
        KMP kmp = new KMP();
        System.out.println("is substring: " + kmp.isSubstring("abcabcabcf", "abcabcfa"));
    }
}
