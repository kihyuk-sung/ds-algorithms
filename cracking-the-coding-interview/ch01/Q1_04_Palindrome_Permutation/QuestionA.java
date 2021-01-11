package ch01.Q1_04_Palindrome_Permutation;

import java.util.Scanner;

public class QuestionA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        boolean[] touchTable = new boolean[28]; // input will be 'a' to 'z' string

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if('a' <= c && c <= 'z') {
                int idx = c - 'a';
                touchTable[idx] = !touchTable[idx];
            }
        }

        int moreChane = 0;
        for (boolean b : touchTable) {
            if (b) {
                moreChane++;
            }
            if (moreChane > 1) {
                System.out.println(false);
                System.exit(0);
            }
        }
        System.out.println(true);
    }
}
