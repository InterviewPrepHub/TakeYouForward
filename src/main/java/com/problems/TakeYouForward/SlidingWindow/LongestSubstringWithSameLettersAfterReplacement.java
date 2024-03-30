package com.problems.TakeYouForward.SlidingWindow;

import java.util.Collection;
import java.util.HashMap;

public class LongestSubstringWithSameLettersAfterReplacement {

    public static void main(String[] args) {

        //Explanation: Replace the two 'a' with 'b' in the substring 'ababb' to get the longest substring "bbbbb" with same letters.
        String s="abcababb"; int k=2;

        longestSubStringWithSameLetters(s, k);

    }

    private static void longestSubStringWithSameLetters(String s, int k) {

        int window_start = 0;
        HashMap<Character, Integer> charCount = new HashMap<>();
        int max_len = Integer.MIN_VALUE;

        for (int window_end = 0; window_end < s.length(); window_end++) {

            char ch = s.charAt(window_end);
            charCount.put(ch, charCount.getOrDefault(ch, 0)+1);

            int repeatLetterCount = getMaxRepeatLetterCount(charCount);

            int current_window_len = window_end-window_start+1;

            if(current_window_len - repeatLetterCount > k) {    //shrink window
                char start_char = s.charAt(window_start);
                charCount.put(start_char, charCount.get(start_char)-1);
                if (charCount.get(start_char) == 0) {
                    charCount.remove(start_char);
                }
                window_start++;
            }

            max_len = Math.max(max_len, window_end-window_start+1);
        }
    }

    private static int getMaxRepeatLetterCount(HashMap<Character, Integer> charCount) {

        int curr_max_count = 0;

        for (int count : charCount.values()) {
            if(curr_max_count < count) {
                curr_max_count = count;
            }
        }

        return curr_max_count;
    }
}
