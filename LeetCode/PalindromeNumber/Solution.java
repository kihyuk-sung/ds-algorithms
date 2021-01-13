package PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        // hash for 0, 1, 2, ..., 9
        // only one number could come odd times;

        if (x < 0) {
            return false;
        }


        int reversed = reverse(x);

        return reversed == x;

        /*
        boolean[] checkOdd = new boolean[10];
        while (x != 0) {
            int digit = x % 10;
            checkOdd[digit] = !checkOdd[digit];
            x /= 10;
        }
        int count = 0;
        for (boolean check:checkOdd) {
            if (check) {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }

        return true;
        */
    }

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
}
