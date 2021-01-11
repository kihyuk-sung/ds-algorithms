package ch01.Q1_01_Is_Unique;

public class QuestionA {
    public static boolean isUniqueChars(String str) {
        boolean[] char_hash = new boolean[128];
        if (str.length() > 128)
            return false;
        for (int i = 0; i < str.length(); i++) {
            int hash_key = str.charAt(i);
            if (char_hash[hash_key])
                return false;
            char_hash[hash_key] = true;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String[] words = { "alklkjemvm", "hello", "kite", "padle" };
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars(word));
        }
    }
}
