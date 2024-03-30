package com.problems.TakeYouForward.Heap.Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ReplaceEachArrElementByItsCorrespondingRank {

    public static void main(String[] args) {

        int[] arr = {37,12,28,9,100,56,80,5,12};

        Arrays.sort(arr);

        HashMap<Integer, Integer> map = new HashMap<>();

        int temp = 1;

        for (int i = 0; i < arr.length; i++) {
            //for duplicate case
            if(map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]));
            } else {
                map.put(arr[i], temp);
                temp++;
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey()+","+entry.getValue());
        }
    }
}
