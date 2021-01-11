package problem1076;

import java.util.Scanner;

public class Main {
    enum Color {
        BLACK  (0,1L),
        BROWN  (1,10L),
        RED    (2,100L),
        ORANGE (3,1000L),
        YELLOW (4,10000L),
        GREEN  (5,100000L),
        BLUE   (6,1000000L),
        VIOLET (7,10000000L),
        GREY   (8,100000000L),
        WHITE  (9,1000000000L);
        private final int value;
        private final long multiplier;
        Color(int value, long multiplier) {
            this.value = value;
            this.multiplier  = multiplier;
        }
        public int getValue() {return value;}
        public long getMultiplier() {return multiplier;}
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] colorStr = new String[3];
        Color[] colors = new Color[3];
        for(int i = 0 ; i < colorStr.length ; ++i) {
            colorStr[i] = sc.nextLine();
            colors[i] = Color.valueOf(colorStr[i].toUpperCase());
        }

        long resister = (colors[0].getValue()*10+colors[1].getValue())*colors[2].getMultiplier();

        System.out.println(resister);

    }
}
