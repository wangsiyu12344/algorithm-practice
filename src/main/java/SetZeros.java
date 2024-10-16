package main.java;

/**
 * 73.時間複雑度：O(mn), 空間複雑度：O(1)
 */
public class SetZeros {

    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean column0Flag = false;
        boolean row0Flag = false;
        for (int i = 0; i < m; i++) {
            if(matrix[i][0] == 0) {
                column0Flag = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                row0Flag = true;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row0Flag) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        if (column0Flag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }


}
