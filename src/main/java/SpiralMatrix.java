package main.java;

import java.util.ArrayList;
import java.util.List;

/**
 *  No.54 spiralOrder1：時間複雑度： O(mn), 空間複雑度：O(mn)
 *        spiralOrder2：時間複雑度：O(mn), 空間複雑度：O(mn)
 */

public class SpiralMatrix {

    public List<Integer> spiralOrder1(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        int matrixSize = m * n;
        boolean[][] isIndexed = new boolean[m][n];
        int i = 0;
        int j = 0;
        resultList.add(matrix[i][j]);
        isIndexed[i][j] = true;
        int direction = 90;
        while (resultList.size() < matrixSize) {
            if (direction == 90 && (j+1) < n && !isIndexed[i][j+1]) {
                isIndexed[i][++j] = true;
                resultList.add(matrix[i][j]);
            } else if (direction == 180 && (i+1) < m && !isIndexed[i+1][j]) {
                isIndexed[++i][j] = true;
                resultList.add(matrix[i][j]);
            } else if (direction == 270 && (j - 1) >= 0 && !isIndexed[i][j-1]) {
                isIndexed[i][--j] = true;
                resultList.add(matrix[i][j]);
            } else if (direction == 0 && (i - 1) >= 0 && !isIndexed[i-1][j]) {
                isIndexed[--i][j] = true;
                resultList.add(matrix[i][j]);
            } else {
                direction = (direction + 90) % 360;
            }
        }
        return resultList;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> resultList = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        traverse(matrix, 0, n-1, 0, m-1, resultList);
        return resultList;
    }

    public static void traverse(int[][] matrix, int left, int right, int top, int bottom, List<Integer> resultList) {
        // 終了条件
        if ((left > right) || (top > bottom)) return;

        int i = left;
        while (i <= right) {
            resultList.add(matrix[top][i++]);
        }
        int j = top+1;
        while (j <= bottom) {
            resultList.add(matrix[j++][right]);
        }
        // 行が複数ある場合のみ
        if (top < bottom) {
            int k = right-1;
            while (k >= left) {
                resultList.add(matrix[bottom][k--]);
            }
        }
        // 列が複数ある場合のみ
        if (left < right) {
            int m = bottom - 1;
            while (m > top) {
                resultList.add(matrix[m--][left]);
            }
        }
        traverse(matrix, left+1, right-1, top+1, bottom-1, resultList);
    }

    public static void main(String[] args) {
        SpiralMatrix spiralMatrix = new SpiralMatrix();
        int[][] question = new int[][] {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integerList = spiralMatrix.spiralOrder2(question);
        System.out.println(integerList);
    }
}
