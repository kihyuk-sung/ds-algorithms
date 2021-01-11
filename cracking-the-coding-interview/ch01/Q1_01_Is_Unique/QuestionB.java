package ch01.Q1_01_Is_Unique;

public class QuestionB {
  public static boolean isUniqueChars(String str) {
    for (int i = 0; i < str.length(); i++) {
      for (int j = i + 1; j < str.length(); j++) {
        if (str.charAt(i) == str.charAt(j))
          return false;
      }
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
