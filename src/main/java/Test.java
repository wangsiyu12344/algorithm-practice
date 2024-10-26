package main.java;

public class Test {

    public String multiply(String num1, String num2) {
        String totalRes = "";
        for (int i = 0; i < num2.length(); i++) {
            StringBuilder res = new StringBuilder();
            int digit2 = num2.charAt(num2.length() - 1 - i) - '0';
            int carry = 0;
            for (int j = 0; j < num1.length(); j++) {
                int digit1 = num1.charAt(num1.length() - 1 - j) - '0';
                carry += digit1 * digit2;
                res.append((char)(carry % 10 + '0'));
                carry /= 10;
            }
            if (carry > 0) {
                res.append((char)(carry + '0'));
            }
            totalRes = addString(res.reverse().toString(), i, totalRes);
        }
        return totalRes;
    }

    public String addString(String res, int i, String totalRes) {
        StringBuilder newRes = new StringBuilder();
        if (totalRes.isEmpty()) {
            totalRes += res;
            return totalRes;
        }
        for (int j = 0; j < i; j++) {
            res += "0";
        }
        int length = Math.max(totalRes.length(), res.length());
        int carry = 0;
        for (int k = 0; k < length; k++) {
            carry += k < totalRes.length() ? (totalRes.charAt(totalRes.length()-1-k)-'0') : 0;
            carry += k < res.length() ? (res.charAt(res.length()-1-k)-'0') : 0;
            newRes.append((char)(carry % 10 + '0'));
            carry /= 10;
        }
        if (carry > 0) {
            newRes.append((char)(carry + '0'));
        }
        return newRes.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "123";
        String num2 =  "456";
        Test test = new Test();
        test.multiply(num1, num2);
    }
}
