package weiredstring;

public class Solution {
    public String solution(String s) {
        char[] charArray = s.toCharArray();

        int offset = 'a' - 'A';

        int wordIdx = 0;
        for (int i = 0; i < charArray.length; i++) {
            if ('a' <= charArray[i] && charArray[i] <= 'z') {
                if (wordIdx % 2 == 0) {
                    charArray[i] -= offset;
                }
                wordIdx++;
            } else if ('A' <= charArray[i] && charArray[i] <= 'Z') {
                if (wordIdx % 2 == 1) {
                    charArray[i] += offset;
                }
                wordIdx++;
            } else if (charArray[i] == ' ' || charArray[i] == '\t' || charArray[i] == '\n'){
                wordIdx = 0;
            }
        }
        return new String(charArray);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String input = "try    helldafasdfo \t  adfasdfasd world";
        System.out.println(s.solution(input));
    }
}
