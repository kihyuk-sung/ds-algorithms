package problem1052;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void byteAddOne (boolean[] byteA) {
        boolean carry_in  = true;
        for(int i = 0 ; i < byteA.length; ++i) {
            boolean tmp = byteA[i];
            byteA[i] = byteA[i]^carry_in;
            carry_in = tmp&carry_in;
        }
    }

    public static int bin2dec(boolean[] bin) {
        int answer = 0;

        for (int i = 0, digit = 1; i < bin.length; i++,digit *= 2) {
            if(bin[i])
                answer += digit;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" +");
        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int tmp = N;
        int binaryLength = 0;
        while (tmp != 0) {
            tmp /= 2;
            ++binaryLength;
        }

        boolean[] binaryN = new boolean[binaryLength];
        int binaryCount = 0;
        int i = 0;
        while(N != 0) {
            if(N%2 == 1) {
                binaryN[i] = true;
                ++binaryCount;
            } else {
                binaryN[i] = false;
            }
            N /= 2;
            ++i;
        }

        if(binaryCount <= K) {
            System.out.println(0);
            System.exit(0);
        }

        int MSB_count = 0;
        i = 0;
        while(MSB_count < K-1) {
            if(binaryN[binaryN.length-1-i]) {
                ++MSB_count;
            }
            ++i;
        }

        while(true) {
            if(!binaryN[binaryN.length-1-i]) {
                ++i;
            } else {
                break;
            }
        }

        boolean[] binaryN_sub =  Arrays.copyOf(binaryN,binaryN.length-i);

        for (int ii = 0; ii < binaryN_sub.length; ++ii) {
            binaryN_sub[ii] = !binaryN_sub[ii];
        }

        byteAddOne(binaryN_sub);

        int buyCount = bin2dec(binaryN_sub);

        System.out.println(buyCount);
    }
}



class Main_bruteforce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" +");

        int N = Integer.parseInt(inputs[0]);
        int K = Integer.parseInt(inputs[1]);

        int N_tmp = N;
        int buyCount = 0;

        int binaryCount;
        while(true) {
            binaryCount = 0;
            while(N_tmp > 0) {
                binaryCount += N_tmp % 2;
                N_tmp /= 2;
            }
            if(binaryCount <= K) break;
            else {
                N_tmp = N + ++buyCount;
            }
        }

        System.out.println(buyCount);

    }
}
