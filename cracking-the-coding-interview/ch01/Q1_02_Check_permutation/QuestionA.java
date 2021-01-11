package ch01.Q1_02_Check_permutation;

public class QuestionA {
    public static boolean checkPermutation(String str1, String str2) {
        int[] char_hash = new int[128];

        if (str1.length() != str2.length())
            return false;

        for (int i = 0; i < str1.length(); i++) {
            int hash_key = str1.charAt(i);
            char_hash[hash_key]++;
        }
        for (int i = 0; i < str2.length(); i++) {
            int hash_key = str2.charAt(i);
            char_hash[hash_key]--;
            if (char_hash[hash_key] < 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        String[] words = { "alii", "iial", "kite", "padle", "itke" };
        System.out.println(words[0] + ", " + words[1] + ": " + checkPermutation(words[0], words[1]));
        System.out.println(words[0] + ", " + words[2] + ": " + checkPermutation(words[0], words[2]));
        System.out.println(words[0] + ", " + words[3] + ": " + checkPermutation(words[0], words[3]));
        System.out.println(words[2] + ", " + words[4] + ": " + checkPermutation(words[2], words[4]));
    }
}
