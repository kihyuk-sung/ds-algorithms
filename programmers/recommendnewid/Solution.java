public class Solution {
    public String solution(String new_id) {
        String first = new_id.toLowerCase();
        String second = first.replaceAll("[^a-z0-9-_\\.]", "");
        String third = second.replaceAll("\\.{2,}", "\\.");
        String forth = third.replaceAll("^\\.|\\.$", "");
        String fifth = ("".equals(forth)) ? "a" : forth;
        String sixth = fifth;
        if (sixth.length() >= 16) {
            sixth = sixth.substring(0,15);
            sixth = sixth.replaceAll("\\.$", "");
        }
        StringBuilder seventh = new StringBuilder(sixth);
        if (seventh.length() <= 2) {
            while (seventh.length() <= 2) {
                seventh.append(seventh.charAt(seventh.length() - 1));
            }
        }
        return seventh.toString();
    }
}