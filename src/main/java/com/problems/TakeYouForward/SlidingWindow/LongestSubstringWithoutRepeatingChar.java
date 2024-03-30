package com.problems.TakeYouForward.SlidingWindow;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {

    public static void main(String[] args) {

        String str = "aababcbb";

        longestSubstring(str);
    }

    private static void longestSubstring(String str) {

        int repeatedLetter = 0;
        int window_start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int max_len = Integer.MIN_VALUE;

        for (int window_end = 0; window_end < str.length(); window_end++) {
            char ch = str.charAt(window_end);
            map.put(ch, map.getOrDefault(ch, 0)+1);

            repeatedLetter = getRepeatedLetter(map);
            if(repeatedLetter>1) {
                char start_char = str.charAt(window_start);
                map.put(ch, map.get(ch)-1);
                if(map.get(ch) == 0) {
                    map.remove(ch);
                }
                window_start++;
            }
            max_len = Math.max(max_len, window_end-window_start+1);
        }

        System.out.println(max_len);
    }

    private static int getRepeatedLetter(HashMap<Character, Integer> map) {
        int curr_count = 0;
        for (int count : map.values()) {
            if(curr_count < count) {
                curr_count = count;
            }
        }
        return curr_count;
    }
}
