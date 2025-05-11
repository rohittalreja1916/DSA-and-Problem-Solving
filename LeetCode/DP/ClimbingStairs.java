/*
 * Question : https://leetcode.com/problems/climbing-stairs
* Difficulty : Easy
 * Topics : Math Dynamic Programming Memoization
*/

// Based on the Fibonacci series, the number of ways to climb n stairs is equal to the sum of the number of ways to climb (n-1) stairs and (n-2) stairs.

/*
 * Approach -1 : Memoization
 * TC : O(n)
 * SC : O(n) for dp array
 *
 * Approach -2 : Tabulation
 * TC : O(n)
 * SC : O(n) for dp array
 *
 * Approach -3 : Memory efficient
 * TC : O(n)
 * SC : O(1)
 */

package DP;

import java.util.Arrays;

public class ClimbingStairs {
    public static void main(String[] args) {
        int n = 5;

        int ans = climbStairs(n);
        System.out.println(ans);
    }

    public static int climbStairs(int n) {
        // Memoization
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int ans = memoization(n, dp);
        System.out.println("Memoization " + ans);

        // Tabulation
        System.out.println("Tabulation " + tabulation(n));

        // Space optimization / Memory efficient
        System.out.println("Memory efficient " + memory_efficient(n));

        return ans;
    }

    public static int memoization(int n, int dp[]) {
        if(dp[n] != -1) return dp[n];
         if(n<=1)return dp[n] = 1;
        return dp[n] = memoization(n-1, dp)+ memoization(n-2, dp);
    }

    public static int tabulation(int n) {
        if(n==1) return n;
        int dp[] = new int[n+1];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n-1];
    }

    public static int memory_efficient(int n) {
        int prev1 = 1;
        int prev2 = 1;
        int curr = 0;
        for(int i=2; i<=n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return n == 1 ? prev1 : prev2;
    }
}
