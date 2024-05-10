package com.problems.TakeYouForward.SlidingWindow;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
https://medium.com/@kajol_singh/intuit-interview-experience-sde-ii-b479c8b0edd0

Given an array consisting of N integers. In one move, We can choose any element in this array and
replace it with any other number. Find the longest possible length of consistent segment given max 3 moves.

Input: arr[]  = {2,3,3,3,3,1}
Output: int  = 6
 */
public class LongestConsistentSegment {

    public int lcs(int[] arr, int moves) {

        int n = arr.length;
        int maxLen = 0;
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            while (freqMap.size() > 2 && moves < 3) {   //more than 2 distinct elements within the current window.
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0)
                    freqMap.remove(arr[left]);
                left++;
                moves++;
            }

            if (freqMap.size() <= 2) {
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                moves--;
            }
        }

        return maxLen;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,3,3,3,1};

        LongestConsistentSegment l = new LongestConsistentSegment();
        l.lcs(arr,3);
    }
}
