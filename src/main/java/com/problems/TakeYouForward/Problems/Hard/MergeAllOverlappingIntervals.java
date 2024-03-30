package com.problems.TakeYouForward.Problems.Hard;

import java.util.ArrayList;
import java.util.List;

public class MergeAllOverlappingIntervals {

    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
//        int[][] arr = {{1, 3}, {2, 4}, {3, 5}, {6, 7}};

//        int[][] arr = {{2,2}, {2,3}, {2,5}, {3,6}, {4,4}, {4,5}, {6,6}};

        int[][] arr = {{1,2}, {1,3}, {1,6}, {3,4}, {4,4}, {4,5}, {5,5}, {6,6},{6,6}};

        for (int row = 0; row < arr.length; row++) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(arr[row][0]);
            innerList.add(arr[row][1]);
            list.add(innerList);
        }

        List<List<Integer>> res = mergeOverlappingIntervals(list);
        for (List<Integer> l1 : res) {
            for (Integer i : l1) {
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }

    static int i = 0;
    static List<List<Integer>> mergeOverlappingIntervals(List<List<Integer>> list){

        if (list.size() == 1) {
            return list;
        }

//        if (list.size() == 2 && list.get(0).get(1) < list.get(1).get(0)) {
//            return list;
//        }

        if (i+1 < list.size()) {

            List<Integer> current = list.get(i);
            List<Integer> next = list.get(i + 1);

            if(current.get(1) >= next.get(0)) {

                current.remove(1);
                current.add(next.get(1));

                list.remove(i+1);

                mergeOverlappingIntervals(list);
            } else {
                i++;
                mergeOverlappingIntervals(list);
            }

        }
        return list;
    }
}
