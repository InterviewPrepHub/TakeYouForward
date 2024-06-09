package com.problems.TakeYouForward.TusharRoy.DP;

public class EggDropping {

    public static void main(String[] args) {
        int k = 2;  //no of eggs
        int n = 6;  //no of floors

        System.out.println(superEggDrop(k, n));
    }

    public static int superEggDrop(int eggs, int floors){

        int T[][] = new int[eggs+1][floors+1];
        int c =0;
        for(int i=0; i <= floors; i++){
            T[1][i] = i;
        }

        for(int e = 2; e <= eggs; e++){
            for(int f = 1; f <=floors; f++){
                T[e][f] = Integer.MAX_VALUE;
                for(int k = 1; k <=f ; k++){
                    c = 1 + Math.max(T[e-1][k-1], T[e][f-k]);
                    if(c < T[e][f]){
                        T[e][f] = c;
                    }
                }
            }
        }
        return T[eggs][floors];
    }
}
