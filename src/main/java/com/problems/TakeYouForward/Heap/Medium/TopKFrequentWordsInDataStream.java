package com.problems.TakeYouForward.Heap.Medium;

import java.util.*;

public class TopKFrequentWordsInDataStream {

    int k;
    HashMap<String,Integer> map;
    PriorityQueue<String> pq;


    TopKFrequentWordsInDataStream(int k) {
        this.k = k;
        this.map = new HashMap<>();
        this.pq = new PriorityQueue<>((w1,w2) -> {
            int freq = map.get(w2)- map.get(w1);
            return freq == 0 ? w1.compareTo(w2) : freq;
        });
    }

    public static void main(String[] args) {
        TopKFrequentWordsInDataStream t = new TopKFrequentWordsInDataStream(2);
        t.add("lint");
        t.add("code");
        t.add("code");

        System.out.println(t.topK()); // Output: [code, lint]
        t.add("divya");
        t.add("divya");
        t.add("divya");
        t.add("pali");
        t.add("pali1");
        t.add("pali1");

        System.out.println(t.topK());
    }

    private List<String> topK() {
        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll());
        }
        return list;
    }

    private void add(String str) {
        map.put(str, map.getOrDefault(str,0)+1);
        updateTopK(str);
    }

    private void updateTopK(String str) {
        if (pq.contains(str)) {
            pq.remove(str);
        }
        pq.add(str);
        if (pq.size() > k) {
            pq.poll();
        }
    }


}


