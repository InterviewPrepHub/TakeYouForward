package com.problems.TakeYouForward.TusharRoy.DP;

public class PalindromicPartition {

    public static void main(String[] args) {

        String s = "abcbm";
        int n = s.length();
        solution(s, "");
    }

    private static void solution(String s, String asf) {

        if(s.length() == 0) {
            System.out.println(asf);
            return;
        }

        for (int i = 0; i < s.length(); i++) {

            String prefix = s.substring(0,i+1);

            String ros = s.substring(i+1);

            if(isPalin(prefix)) {
                solution(ros, asf+"("+prefix+")");
            }

        }
    }

    private static boolean isPalin(String s) {
        int i = 0, j = s.length()-1;
        while(i<=j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
