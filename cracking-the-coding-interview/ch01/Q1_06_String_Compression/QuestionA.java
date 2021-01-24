package ch01.Q1_06_String_Compression;

public class QuestionA {
    public static void main(String[] args) {
        String str = "aabccccaaa";
        System.out.println(stringCompression(str));
    }
    public static String stringCompression(String str) {
        StringBuilder sb = new StringBuilder();
        char[] charArray = str.toCharArray();
        int count = 0;
        char state = ' ';
        for (char c : charArray) {
            if (state == ' ') {
                state = c;
                count = 1;
                sb.append(state);
            } else if (state == c) {
                count++;
            } else if (state != c) {
                sb.append(count);
                count = 1;
                state = c;
                sb.append(state);
            }
        }
        sb.append(count);
        if (sb.length() > str.length()) {
            return str;
        } else {
            return sb.toString();
        }

    }
}
