package com.problems.TakeYouForward.Pepcoding.Backtracking;

public class PalindromicPermutations {

    public static void main(String[] args) {
        printPermutation("abc", "");
    }

    private static void printPermutation(String s, String asf) {

        if(s.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String ros = s.substring(0, i) + s.substring(i + 1);
            printPermutation(ros, asf + ch);
        }
    }
}
