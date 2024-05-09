package com.problems.TakeYouForward.TusharRoy.DP;

public class InterleavingStrings {

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";

        solution(s1, s2, s3);
    }

    private static void solution(String s1, String s2, String s3) {
        int i = 0, j = 0, k = 0;

        Boolean[][] T = new Boolean[s1.length()+1][s2.length()+1];

        if(s1.length() + s2.length() != s3.length()) {
            System.out.println(false);
        } else {
            boolean res = solution(s1,s2,s3, i, j, T);
            System.out.println(res);
        }
    }

    private static boolean solution(String s1, String s2, String s3, int i, int j, Boolean[][] T) {

        if(i == s1.length()-1 && j == s2.length()-1) {
            return true;
        }

        if(T[i][j] != null) return T[i][j];

        if(i<s1.length() && s1.charAt(i) == s3.charAt(i+j)) {
            boolean f1 = solution(s1,s2,s3, i+1,j, T);
            T[i][j] = f1;
            if(f1) return true;
        }

        if(j<s2.length() && s2.charAt(j) == s3.charAt(i+j)) {
            boolean f2 = solution(s1,s2, s3, i,j+1, T);
            T[i][j] = f2;
            if (f2) return true;
        }

        T[i][j] = false;
        return false;
    }
}
