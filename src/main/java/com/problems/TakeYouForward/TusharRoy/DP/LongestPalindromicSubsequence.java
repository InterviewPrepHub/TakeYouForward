package com.problems.TakeYouForward.TusharRoy.DP;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {

        String s = "bbbab";

        System.out.println(lps(s, 0, s.length()-1));
    }

    private static int lps(String s, int n, int m) {

        if(n==m) return 1;

        if(s.charAt(n) == s.charAt(m) && n+1==m) return 2;

        if (s.charAt(n) == s.charAt(m)) {
            return 2 + lps(s, n+1, m-1);
        } else {
            return Math.max(lps(s,n+1,m) , lps(s,n,m-1));
        }
    }

}
