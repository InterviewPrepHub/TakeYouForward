package com.problems.TakeYouForward.TusharRoy.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakI {

    public static void main(String[] args) {
        /*String s = "catsanddog";

        List<String> dict = new ArrayList<>();
        dict.add("cat");
        dict.add("cats");
        dict.add("sand");
        dict.add("dog");*/

        String s = "leetcode";

        List<String> dict = new ArrayList<>();
        dict.add("leet");
        dict.add("code");

        WordBreakI w = new WordBreakI();
        System.out.println(w.wordBreak(s, dict));
    }

    private boolean wordBreak(String s, List<String> dict) {
        Set<String> set = new HashSet<>(dict);
        StringBuilder ans = new StringBuilder();
        return wordBreak(s, set, ans);
    }

    private boolean wordBreak(String s, Set<String> dict, StringBuilder ans) {

        if (s.length() == 0) {
            System.out.println(ans.toString());
            return true;
        }

        StringBuilder word = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            word.append(ch);

            if (dict.contains(word.toString())) {
                int currLength = word.length();
                ans.append(word).append(" ");
                if (wordBreak(s.substring(i + 1), dict, ans)) {
                    return true;
                }
                word.setLength(currLength); //backtrack
            }
        }
        return false;
    }


}





















