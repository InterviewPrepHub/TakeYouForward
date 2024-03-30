package com.problems.TakeYouForward.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinWindowSubstring {

    public static void main(String[] args) {
        String input = "ADOBECODEBANC", t = "ABC";
//        Output: "BANC"
//        Explanation: The smallest substring of s that includes all the characters of t is "BANC".
        
        minWindow(input, t);
    }

    private static void minWindow(String input, String t) {

        Map<Character, Integer> charCount1 = new HashMap<>();

        for (char ch : t.toCharArray()) {
            charCount1.put(ch, charCount1.getOrDefault(ch, 0)+1);
        }

        int window_start = 0;
        int window_substr_start = 0;
        Map<Character, Integer> charCount2 = new HashMap<>();

        int min_len = Integer.MAX_VALUE;

        for (int window_end = 0; window_end<input.length(); window_end++) {
            char ch = input.charAt(window_end);
            charCount2.put(ch, charCount2.getOrDefault(ch, 0)+1);

            while(compareCharCount(charCount1, charCount2)) {
                min_len = Math.min(min_len, window_end-window_start+1);
                window_substr_start = window_start;

                char start_ch = input.charAt(window_start);
                charCount2.put(start_ch, charCount2.get(start_ch)-1);
                if(charCount2.get(start_ch) == 0) {
                    charCount2.remove(start_ch);
                }
                window_start++;
            }
        }
        System.out.println(input.substring(window_substr_start, window_substr_start+min_len));
    }

    private static boolean compareCharCount(Map<Character, Integer> charCount1, Map<Character, Integer> charCount2) {

        for(Map.Entry<Character, Integer> entry : charCount1.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();

            if(!charCount2.containsKey(c)) {
                return false;
            }

            if(charCount2.get(c) < count) {
                return false;
            }
        }
        return true;
    }
}
