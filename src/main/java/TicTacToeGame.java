package main.java;

/**
 * No.1275
 */

public class TicTacToeGame {

    private int[][] board = new int[3][3];

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        for (int i = 2; i < coordinates.length; i++) {
            if ((coordinates[i][0] - coordinates[i - 1][0]) * (coordinates[i - 1][1] - coordinates[i - 2][1]) != (coordinates[i - 1][0] - coordinates[i - 2][0]) * (coordinates[i][1] - coordinates[i - 1][1])) {
                return false;
            }
        }
        return true;
    }

    public String tictactoe(int[][] moves) {
        for (int i = 0; i < moves.length; i++) {
            int x = moves[i][0];
            int y = moves[i][1];
            if (i % 2 == 0) {
                board[x][y] = 1;
                if (check(x, y, 1)) return "A";
            } else {
                board[x][y] = 2;
                if (check(x, y, 2)) return "B";
            }
        }
        return moves.length == 9 ? "Draw" : "Pending";
    }

    public boolean check(int x, int y, int player) {
        if (board[x][0] == player && board[x][1] == player && board[x][2] == player) return true;
        if (board[0][y] == player && board[1][y] == player && board[2][y] == player) return true;
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }


}
