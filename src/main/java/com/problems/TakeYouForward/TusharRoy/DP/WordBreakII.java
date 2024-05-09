package com.problems.TakeYouForward.TusharRoy.DP;

import java.util.ArrayList;
import java.util.List;

public class WordBreakII {

    public static void main(String[] args) {
        
        String s = "catsanddog";
        List<String> list = new ArrayList<>();
        list.add("cat");
        list.add("cats");
        list.add("and");
        list.add("sand");
        list.add("dog");

        StringBuilder ans = new StringBuilder();
        List<String> result = new ArrayList<>();
        wordBreak1(s, list, new ArrayList<>(), result);

        for (String r: result) {
            System.out.println(r);
        }

    }

    public static void wordBreak1(String s, List<String> wordDict, List<String> current, List<String> result) {

        if (s.isEmpty()) {
            result.add(String.join(" ", current));
            return;
        }

        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            word.append(ch);

            if (wordDict.contains(word.toString())) {
                current.add(word.toString());
                wordBreak1(s.substring(i+1), wordDict, current, result);
                current.remove(current.size()-1);
            }
        }
    }

}
