package main.java;

public class AddBinary {

    public String addBinary(String a, String b) {
        String s = "";
        int n = a.length();
        int m = b.length();
        for (int i = 0; i < Math.abs(n-m); i++) {
            s+= "0";
        }
        if (n > m) {
            b = s + b;
        } else {
            a = s + a;
        }
        boolean flag = false;
        String result = "";
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == '1' && b.charAt(i) == '1') {
                if (flag) {
                    result += "1";
                } else {
                    result += "0";
                    flag = true;
                }
            } else if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                if (flag) {
                    result += "0";
                } else {
                    result += "1";
                }
            } else {
                if (flag) {
                    result += "1";
                    flag = false;
                } else {
                    result += "0";
                }
            }
        }
        if (flag) {
            result += "1";
            flag = false;
        }
        return new StringBuilder(result).reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        addBinary.addBinary("11", "1");
    }
}
