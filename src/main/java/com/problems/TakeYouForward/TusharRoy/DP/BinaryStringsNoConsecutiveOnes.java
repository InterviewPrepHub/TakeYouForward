package com.problems.TakeYouForward.TusharRoy.DP;

/*
n = 3
000 - 5
001 - 1
010 - 2
011

100 - 3
101 - 4
110
111

- This is a fibonacci series. for n = 3
- we are adding 0 to all binary numbers for n = 2 and 1 to all binary numbers for n = 2
- after adding 0 to all binary numbers in n = 2 then the number of binary string with consecutive 1's
  will be same as n = 2
- after adding 1 to all binary numbers in n = 2 the we check

n = 1
0,1 -> here we have 2 no consecutive ones
for n = 2
00, 01, 10, 11 -> here we have 3 such no consecutive ones, we add 0 and 1 before all the binary numbers of 1

00.      and     10
01                    11
f(2) = f(1)+f(0) = 2 + 1 = 3

for n= 3
we have n = 2, and we add 1 and zero before each
00
01
10
11

f(3) = f(2)+f(1) = 3 + 2 = 5
000
001
010
011

100
101
110
111
*/
public class BinaryStringsNoConsecutiveOnes {

    public static void main(String[] args) {

        System.out.println(countBinaryStrings(3));
    }

    private static int countBinaryStrings(int n) {

        if (n <= 0) return 0;
        if (n == 1) return 2; // Only "0" and "1"

        int[] dp0 = new int[n + 1]; // Ending with '0'
        int[] dp1 = new int[n + 1]; // Ending with '1'

        // Base cases
        dp0[1] = 1;
        dp1[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp0[i] = dp0[i-1] + dp1[i-1];
            dp1[i] = dp0[i-1];
        }

        return dp0[n] + dp1[n];
    }
}

/*

n = 2
dp0[2] = dp0[n-1] + dp1[n-1] = 1+1=2
dp1[2] = dp0[n-1] = 1
total = dp0[2]+dp1[2] = 3
 */
