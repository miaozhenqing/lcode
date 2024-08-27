package org.example.topinterview150;

public class AddBinary {
    public String addBinary(String a, String b) {
        int ca = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            int value1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int value2 = j >= 0 ? b.charAt(j) - '0' : 0;
            sum += value1;
            sum += value2;
            builder.append(sum % 2);
            ca = sum / 2;
        }
        builder.append(ca == 1 ? ca : "");
        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary("11", "1"));
        System.out.println(addBinary.addBinary("1010", "1011"));
    }
}
