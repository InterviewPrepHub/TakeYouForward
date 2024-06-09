package com.problems.TakeYouForward.TusharRoy.DP;

/*
Given a chain of matrices A1,..., An denoted by an array of size n+1, find out the
minimum number of operations to multiply these n matrices.

Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices.
The cost of matrix multiplication is defined as the number of scalar multiplications.
A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ where the dimension
of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.

For example:
For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]

Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.

Sample Input 1:
2
4
4 5 3 2
4
10 15 20 25
Sample Output 1:
70
8000
Sample Output Explanation 1:
In the first test case, there are three matrices of dimensions A = [4 5], B = [5 3] and C = [3 2]. The most efficient order of multiplication is A * ( B * C).
Cost of ( B * C ) = 5 * 3 * 2 = 30  and (B * C) = [5 2] and A * (B * C) = [ 4 5] * [5 2] = 4 * 5 * 2 = 40. So the overall cost is equal to 30 + 40 =70.

In the second test case, there are two ways to multiply the chain - A1*(A2*A3) or (A1*A2)*A3.

If we multiply in order- A1*(A2*A3), then the number of multiplications required is 11250.

If we multiply in order- (A1*A2)*A3, then the number of multiplications required is 8000.

Thus a minimum number of multiplications required is 8000.

 */
public class MatrixChainMultiplication {

    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50, 60};
        int res = matrixMultiplication(arr, arr.length);
        System.out.println(res);
    }


    public static int matrixMultiplication(int[] arr , int N) {

        int[][] dp = new int[N-1][N-1];
        int m = dp.length;

        for (int len = 0; len < m; len++) {
            for (int i = 0, j = len; j < m; i++, j++) {
                if(len==0) {    // A, B, C .... has 0 gap
                    dp[i][j] = 0;
                } else if(len == 1) {   //AB has gap of len 1
                    dp[i][j] = arr[i] * arr[j] * arr [j+1];
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        //i to k is left half and k +1 to j is right half
                        int lc = dp[i][k];
                        int rc = dp[k+1][j];
                        int mc = arr[i] * arr[k+1] * arr[j+1];
                        int tc = lc + rc + mc;
                        if(tc < min) {
                            min = tc;
                        }
                    }
                    dp[i][j] = min;
                }
            }
            
        }
        return dp[0][m-1];
    }

}
