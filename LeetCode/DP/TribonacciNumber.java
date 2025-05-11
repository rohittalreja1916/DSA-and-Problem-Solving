/*
 * Question : https://leetcode.com/problems/n-th-tribonacci-number
* Difficulty : Easy
 * Topics : Math Dynamic Programming Memoization
*/

package DP;

import java.util.*;

public class TribonacciNumber {
    public static void main(String[] args) {
        int n = 25;

        int ans = tribonacci(n);
        System.out.println(ans);
    }

    public static int tribonacci(int n) {
        // Memoization
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return memoization(n, dp);
    }

    public static int memoization(int n, int dp[]){
        if(dp[n] != -1) return dp[n];
        if (n <= 1) return dp[n] = n;
        if (n == 2) return dp[n] = 1;
        return dp[n] = memoization(n-1, dp) + memoization(n-2, dp) + memoization(n-3, dp);
    }
}
