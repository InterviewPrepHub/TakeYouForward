package com.problems.TakeYouForward.TusharRoy.DP;

public class StaircaseProblem {

    public static void main(String[] args) {
        System.out.println(staircase(3));

//        System.out.println(staircase1(3));
    }

    private static int staircase(int n) {

        if(n==0 || n==1) return 1;

        return staircase(n-1) + staircase(n-2);
    }

    public static int staircase1(int n){

        if (n == 0 || n == 1) {
            return 1;
        }

        int n1 = 1, n2 = 1;
        int sum;

        for(int i=2; i <= n; i++){
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return n2;

    }
}
