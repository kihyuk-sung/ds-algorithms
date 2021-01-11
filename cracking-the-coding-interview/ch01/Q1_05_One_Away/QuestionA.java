package ch01.Q1_05_One_Away;

import java.util.Scanner;

public class QuestionA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine();
            String[] inputs = input.split(", +");

            if (inputs[0].length() == inputs[1].length() || inputs[0].length() - inputs[1].length() == 1) {
                boolean result = check(inputs[0], inputs[1]);
                System.out.println(result);
            } else if (inputs[0].length() - inputs[1].length() == -1) {
                boolean result = check(inputs[1],inputs[0]);
                System.out.println(result);
            } else {
                System.out.println(false);
            }
        }
    }

    public static boolean check(String longStr, String shortStr) {
        int oneChance = 0;
        int idx = 0;
        for (int i = 0; i < longStr.length(); i++) {
            if (longStr.charAt(i) == shortStr.charAt(idx)) {
                idx++;
                if (idx == longStr.length() - 1) {
                    return true;
                }
            } else {
                if (longStr.length() == shortStr.length()) {
                    idx++;
                }
                oneChance++;
                if (oneChance > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean checkWhenLengthEqual(String str1, String str2) {
        int oneChance = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                oneChance++;
                if (oneChance > 1) {
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean checkWhenLengthNotEqual(String longStr, String shortStr) {
        int idxShort = 0;
        int oneChance = 0;
        for (int i = 0; i < longStr.length(); i++) {
            if (longStr.charAt(i) == shortStr.charAt(idxShort)) {
                idxShort++;
                if (idxShort == longStr.length() - 1) {
                    return true;
                }
            } else {
                oneChance++;
                if (oneChance > 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
