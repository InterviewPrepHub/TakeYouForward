package com.problems.TakeYouForward.SlidingWindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CountOcuurencesOfAnagram {

    public static void main(String[] args) {
        String str = "forxxorfxdofr";
        String word = "for";
        System.out.println(countAnagramOccurences(str, word));
    }

    public static boolean checkAnagram(Map<Character, Integer> word1CharCount, Map<Character, Integer> word2CharCount) {
        if (word1CharCount.size() != word2CharCount.size()) {
            return false;
        }
        Set<Character> keys = word1CharCount.keySet();

        for (char ch : keys) {
            if (word1CharCount.get(ch) != word2CharCount.get(ch)) {
                return false;
            }
        }
        return true;
    }
    
    public static int countAnagramOccurences(String word, String target) {

        Map<Character, Integer> word1CharCount = new HashMap<>();
        for (char ch1 : target.toCharArray()) {
            word1CharCount.put(ch1, word1CharCount.getOrDefault(ch1, 0)+1);
        }

        Map<Character, Integer> word2CharCount = new HashMap<>();

        int window_start = 0;
        int k = target.length();
        int count = 0;

        for (int window_end = 0; window_end < word.length(); window_end++) {
            char ch = word.charAt(window_end);
            word2CharCount.put(ch, word2CharCount.getOrDefault(ch, 0)+1);

            if (window_end - window_start + 1 == k) {
                if(checkAnagram(word1CharCount, word2CharCount)) {
                    count++;
                }

                char removeChar = word.charAt(window_start);
                word2CharCount.put(removeChar, word2CharCount.getOrDefault(removeChar, 0)-1);
                if (word2CharCount.get(removeChar) == 0) {
                    word2CharCount.remove(removeChar);
                }
                window_start++;
            }
        }

        return count;
    }
}
