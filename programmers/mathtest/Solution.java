package mathtest;

import java.util.ArrayList;

public class Solution {
    final int[][] ANSWER = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
    };
    public int[] solution(int[] answers) {
        int[] count = new int[3];

        for (int i = 0; i < answers.length; i++) {
            int idxA = i % ANSWER[0].length;
            int idxB = i % ANSWER[1].length;
            int idxC = i % ANSWER[2].length;

            if (answers[i] == ANSWER[0][idxA]) {
                count[0]++;
            }
            if (answers[i] == ANSWER[1][idxB]) {
                count[1]++;
            }
            if (answers[i] == ANSWER[2][idxC]) {
                count[2]++;
            }
        }

        int max = 0;
        for (int c : count) {
            if (c > max) {
                max = c;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if (count[i] == max) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
