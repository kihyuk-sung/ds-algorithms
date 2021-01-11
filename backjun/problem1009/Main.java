package problem1009;
import java.util.*;
public class Main {
    static int[][] firstDigitTable = {
            {10},          // 0 == 10;
            {1},           // 1
            {6,2,4,8},     // 2
            {1,3,9,7},     // 3
            {6,4},         // 4
            {5},           // 5
            {6},           // 6
            {1,7,9,3},     // 7
            {6,8,4,2},     // 8
            {1,9}          // 9
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T > 0) {
            int a, b;
            a = sc.nextInt();
            b = sc.nextInt();

            int aFirstDigit = a % 10;
            int iteration = firstDigitTable[aFirstDigit].length;
            int idx = b % iteration;

            int dataFirstDigit = firstDigitTable[aFirstDigit][idx];

            System.out.println(dataFirstDigit);
            --T;
        }

    }
}
