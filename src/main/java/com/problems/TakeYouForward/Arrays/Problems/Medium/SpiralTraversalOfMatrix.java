package com.problems.TakeYouForward.Arrays.Problems.Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SpiralTraversalOfMatrix {

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 },
                           { 5, 6, 7, 8 },
                           { 9, 10, 11, 12 },
                           { 13, 14, 15, 16 } };

        spiralTraversal(matrix);
    }

    private static void spiralTraversal(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            //for even row traverse each column left to right
            //for odd row  traverse each column right to left

            if(row % 2 == 0) {
                for (int col = 0; col < matrix[0].length; col++) {
                    list.add(matrix[row][col]);
                }
            } else {
                for (int col = matrix[0].length-1; col >= 0 ; col--) {
                    list.add(matrix[row][col]);
                }
            }
        }

        Iterator<Integer> it = list.iterator();

        while(it.hasNext()) {
            System.out.print(it.next() + ", ");
        }

    }
}
