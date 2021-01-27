package TimeConversion;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        Pattern pattern = Pattern.compile("(\\d\\d)(:\\d\\d:\\d\\d)([PA]M)");
        Matcher matcher = pattern.matcher(s);
        if (matcher.find()) {
            int hour = Integer.parseInt(matcher.group(1));
            int addHour = 0;
            if (hour == 12) {
                hour = 0;
            }
            String AMPM = matcher.group(3);
            if (AMPM.equals("PM")) {
                addHour = 12;
            }
            hour += addHour;
            StringBuilder sb = new StringBuilder();
            if (hour < 10) {
                sb.append(0).append(hour);
            } else {
                sb.append(hour);
            }
            sb.append(matcher.group(2));
            return sb.toString();
        } else {
            return "";
        }
    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
