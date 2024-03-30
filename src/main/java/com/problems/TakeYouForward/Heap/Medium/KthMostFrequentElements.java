package com.problems.TakeYouForward.Heap.Medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KthMostFrequentElements {

    public static void main(String[] args) {

        int arr[] = {1,1,1,2,2,3}, k = 3;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i],0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> max_heap = new PriorityQueue<>((a,b) -> a.getValue()-b.getValue());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max_heap.add(entry);

            if(max_heap.size()>=k) {
                System.out.println(max_heap.poll().getValue());
            }
        }


    }
}
