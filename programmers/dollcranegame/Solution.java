package dollcranegame;

import java.util.Stack;

public class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            int idx = move - 1;
            for (int[] row : board) {
                int boardItem = row[idx];
                if (boardItem != 0) {
                    if (!basket.empty()) {
                        int stackItem = basket.pop();
                        if (boardItem == stackItem) {
                            answer += 2;
                        } else {
                            basket.push(stackItem);
                            basket.push(boardItem);
                        }
                    } else {
                        basket.add(boardItem);
                    }
                    row[idx] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {
                {0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3,5,1,3,1}
        };
        int[] moves = {1,5,3,5,1,2,1,4};

        Solution s = new Solution();
        System.out.println((s.solution(board, moves)));

    }
}
