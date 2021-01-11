package problem10757;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] inputs = input.split(" +");
        String A = inputs[0];
        String B = inputs[1];
        int num_digit = 0;
        int A_digit = 0;
        int B_digit = 0;
        if(A.length() > B.length())
            num_digit = A.length()+1;
        else
            num_digit = B.length()+1;

        char[] result = new char[num_digit];
        int carry_in = 0;
        int sum = 0;
        for(int i = 0 ; i < num_digit-1 ; ++i) {

            try {
                A_digit = A.charAt(A.length()-1-i) - '0';
            } catch (StringIndexOutOfBoundsException e) {
                A_digit = 0;
            }

            try {
                B_digit = B.charAt(B.length()-1-i)-'0';
            } catch (StringIndexOutOfBoundsException e) {
                B_digit = 0;
            }

            sum = A_digit + B_digit + carry_in;
            result[num_digit-1-i] = (char)(sum%10+'0');
            carry_in = sum/10;
        }
        if(carry_in != 0)
            result[0] = (char)(carry_in+'0');
        else
            result = Arrays.copyOfRange(result,1,result.length);

        String result_str= new String(result);
        System.out.println(result_str);
    }
}
