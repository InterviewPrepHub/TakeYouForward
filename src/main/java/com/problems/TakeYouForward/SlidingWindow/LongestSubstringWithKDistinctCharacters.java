package com.problems.TakeYouForward.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithKDistinctCharacters {

    public static void main(String[] args) {
        String str = "aabacbebebe";
        int k = 3;

        longestSubstring(str, k);
    }

    private static void longestSubstring(String str, int k) {

        int window_start = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int window_end = 0; window_end < str.length(); window_end++) {

            char ch = str.charAt(window_end);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            while (map.size() > k) {
                char start_ch = str.charAt(window_start);
                map.put(start_ch, map.get(start_ch)-1);

                if (map.get(start_ch) == 0) {
                    map.remove(start_ch);
                }
                window_start++;
            }

        }

        int count = 0;

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            count += entry.getValue();
        }

        System.out.println(count);
    }


}
