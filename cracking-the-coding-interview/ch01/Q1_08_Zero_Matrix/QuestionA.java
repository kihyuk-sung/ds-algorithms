package ch01.Q1_08_Zero_Matrix;

import java.util.Arrays;

public class QuestionA {
    public static void zeroRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[row].length; i++) {
            matrix[row][i] = 0;
        }
    }

    public static void zeroCol(int[][] matrix, int col) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void zeroMatrix(int[][] matrix) {
        int M = matrix.length;
        int N = matrix[0].length;

        boolean[] row = new boolean[M];
        boolean[] col = new boolean[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (row[i]) {
                zeroRow(matrix, i);
            }
        }

        for (int i = 0; i < N; i++) {
            if (col[i]) {
                zeroCol(matrix, i);
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3,4,0,4},
                {1,2,3,4,1,4},
                {1,2,3,4,3,4},
                {1,2,0,4,4,4},
                {1,2,3,4,5,4},
        };
        zeroMatrix(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
