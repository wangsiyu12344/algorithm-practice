package main.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Calculator {

    Stack<String> ops = new Stack<>();
    Stack<Double> nums = new Stack<>();

    private Double calculate(String str) {
        char[] chars = str.toCharArray();
        for (char ch : chars) {
            if (ch != ' ') {
                if (ch == '(') {
                } else if (ch == '+') {
                    ops.push(String.valueOf(ch));
                } else if (ch == '-') {
                    ops.push(String.valueOf(ch));
                } else if (ch == '*') {
                    ops.push(String.valueOf(ch));
                } else if (ch == '/') {
                    ops.push(String.valueOf(ch));
                } else if (ch == ')') {
                    // 弹出运算符和操作符，计算结果并压入栈。
                    startToOperate();
                } else {
                    nums.push(Double.valueOf(String.valueOf(ch)));
                }
            }
        }
        while (ops.size() > 0) {
            startToOperate();
        }
        return nums.pop();
    }

    private void startToOperate() {
        String op = ops.pop();
        Double v = nums.pop();
        if ("+".equals(op)) {
            v = v + nums.pop();
        } else if ("-".equals(op)) {
            v = nums.pop() - v;
        } else if ("*".equals(op)) {
            v = v * nums.pop();
        } else if ("/".equals(op)) {
            v = nums.pop() / v;
        }
        nums.push(v);
    }

    public static void main(String[] args) {
        try {
            while (true) {
                System.out.println("please type in a str: ");
                // put in a str in the console
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                Double result = new Calculator().calculate(line);
                System.out.println("the calculation result is: " + result);
            }
        } catch (IOException e) {
            System.out.println("failed to read str from the console due to " + e.getMessage());
        }
    }
}
