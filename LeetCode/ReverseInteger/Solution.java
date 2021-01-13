package ReverseInteger;

public class Solution {
    public int reverse(int x) {
        boolean isNeg = false;
        if (x < 0) {
            isNeg = true;
            x = -x;
        }

        int result = 0;
        while (x != 0) {
            long test = (long) result * 10;
            if (test != result * 10) {
                return 0;
            }
            result *= 10;
            result += x % 10;
            x /= 10;
        }

        if (isNeg) {
            result = -result;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution ri = new Solution();
        ri.reverse(1534236469);
    }
}
