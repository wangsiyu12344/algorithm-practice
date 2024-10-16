package main.java;

/**
 * No.1041
 */

public class RobotBoundedInCircle {

    private boolean isRobotBounded(String instructions) {
        int[][] point = new int[][] {{0,0}};
        int direction = 0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                direction = (direction + 90) % 360;
            } else if (instructions.charAt(i) == 'R') {
                direction = ((direction - 90) + 360) % 360;
            } else {
                if (direction == 0) {
                    point[0][1] = point[0][1] + 1;
                } else if (direction == 90) {
                    point[0][0] = point[0][0] - 1;
                } else if (direction == 180) {
                    point[0][1] = point[0][1] - 1;
                } else {
                    point[0][0] = point[0][0] + 1;
                }
            }
        }
        // まだ原点にいるのであれば、trueを返却
        if (point[0][0] == 0 && point[0][1] == 0) {
            return true;
        }
        // 原点にいないかつ北を向いているのであれば、falseを返却
        if (direction == 0) return false;

        // 原点にいない且つ北を向いていないのであれば、instructionを2回もしくは四回を実行すると必ず原点に戻るため、trueを返却
        return true;
    }

    public static void main(String[] args) {

    }
}
