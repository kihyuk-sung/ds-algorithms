package LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        char check;
        if (strs != null) {
            try {
                check = strs[0].charAt(0);
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        boolean notEqual = false;

        checkIdx:
        while (!notEqual) {
            for (String str:strs) {
                try {
                    if (check != str.charAt(idx)) {
                        notEqual = true;
                        continue checkIdx;
                    }
                } catch (Exception e) {
                    notEqual = true;
                    continue checkIdx;
                }

            }
            sb.append(check);
            try {
                check = strs[0].charAt(++idx);
            } catch (Exception e) {
                notEqual = true;
                continue checkIdx;
            }
        }
        return sb.toString();
    }
}
