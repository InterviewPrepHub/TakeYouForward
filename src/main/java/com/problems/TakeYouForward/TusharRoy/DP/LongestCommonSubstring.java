package com.problems.TakeYouForward.TusharRoy.DP;

public class LongestCommonSubstring {

    public static void main(String[] args) {
        String s1 = "abcdaf";
        String s2 = "zbcdf";

        int n = s1.length();
        int m = s2.length();

        int T[][] = new int[n+1][m+1];

        int max = Integer.MIN_VALUE;
        for(int i=1; i <= s1.length(); i++){
            for(int j=1; j <= s2.length(); j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    T[i][j] = T[i-1][j-1] + 1;
                } else {
                    T[i][j] = 0;
                }
                if(max < T[i][j]){
                    max = T[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
