package ch01.Q1_03_URLify;

public class QuestionA {
  public static String URLify(String str) {
    char[] charArray = new char[str.length() * 3];
    int idx_charArray = 0;
    for (int ii = 0; ii < str.length(); ii++) {
      char char_tmp = str.charAt(ii);
      if (char_tmp == ' ') {
        charArray[idx_charArray] = '%';
        charArray[idx_charArray + 1] = '2';
        charArray[idx_charArray + 2] = '0';
        idx_charArray += 3;
      } else {
        charArray[idx_charArray] = char_tmp;
        idx_charArray++;
      }
    }
    return new String(charArray);
  }

  public static void main(String[] args) {
    System.out.println(URLify("Mr John Smith"));
  }
}
