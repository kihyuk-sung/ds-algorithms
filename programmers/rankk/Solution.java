package rankk;

import java.util.Arrays;

public class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] subArray = new int[commands[i][1] - commands[i][0] + 1];
            for (int j = 0; j < subArray.length; j++) {
                subArray[j] = array[commands[i][0] - 1 + j];
            }
            answer[i] = rank(subArray, 0, subArray.length - 1, commands[i][2] - 1);
        }
        return answer;
    }

    public int rank(int[] array, int p, int q, int i) {
        if (p == q) {
            return array[p];
        }
        int length = q - p + 1;
        int pivotFirstIdx = p + (int) (Math.random() * length);

        int pivot = array[pivotFirstIdx];
        array[pivotFirstIdx] = array[p];
        array[p] = pivot;
        int pivotIdx = 0;
        for (int ii = 1; ii < length; ii++) {
            int idx = p + ii;
            if (pivot > array[idx]) {
                pivotIdx++;
                int tmp = array[idx];
                int pivotNow = p + pivotIdx;
                array[idx] = array[pivotNow];
                array[pivotNow] = tmp;
            }
        }
        int pivotIdxNow = p + pivotIdx;
        array[p] = array[pivotIdxNow];
        array[pivotIdxNow] = pivot;
        if (pivotIdx == i) {
            return array[pivotIdxNow];
        } else if (i < pivotIdx) {
            return rank(array, p, pivotIdxNow - 1, i);
        } else {
            return rank(array, pivotIdxNow + 1, q, i - pivotIdx - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] command = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(array, command)));
    }
}
