package com.problems.TakeYouForward.Heap.Medium;

import java.util.*;

public class TaskScheduler {

    public static void main(String[] args) {
        char[] ch = {'A','A','A','B','C','C'};
        int n = 2;
        topKFreq(ch, n);
    }

    public static void topKFreq(char[] tasks, int n) {

        int time = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(char ch : tasks) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        PriorityQueue<Task> max_heap = new PriorityQueue<>(new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                return o2.freq - o1.freq;
            }
        });

        for(Map.Entry<Character, Integer> entry : map.entrySet()) {
            Task task = new Task(entry.getValue(), 0);
            max_heap.add(task);
        }

        Queue<Task> queue = new LinkedList<>();

        while (!max_heap.isEmpty() || !queue.isEmpty()) {
            if(!queue.isEmpty() && time-queue.peek().time > n) {
                max_heap.add(queue.poll());
            }
            if(!max_heap.isEmpty()) {
                Task topTask = max_heap.poll();
                topTask.freq--;
                topTask.time = time;

                if(topTask.freq > 0) {
                    queue.add(topTask);
                }
                time++;
            }
        }

        System.out.println(time);

    }
}

class Task {
    int freq;
    int time;

    Task(int freq, int time) {
        this.freq = freq;
        this.time = time;
    }
}
