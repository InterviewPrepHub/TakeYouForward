package com.problems.TakeYouForward.Problems.Medium;

import com.problems.TakeYouForward.Utils.PrintArray;

public class RotateMatrixBy90Degrees {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        rotateMatrix(matrix);

        PrintArray.printMatrix(matrix);
    }

    private static void rotateMatrix(int[][] matrix) {

        int n = matrix.length;

        for (int i = 0; i < n/2; i++) {
            for (int j = i; j < n-i-1; j++) {
                int temp = matrix[i][j];    //left most top corner
                matrix[i][j] = matrix[n-1-j][i];   //left most bottom corner
                matrix[n-1-j][i] = matrix[n-1-j][n-1-j];
                matrix[j][n-1-i] = temp;
            }
        }
    }
}
