/*
 * Question : https://leetcode.com/problems/min-cost-climbing-stairs
* Difficulty : Easy
 * Topics : Array Dynamic Programming
*/

/*
 * Approach -1 : Memoization
 * TC : O(n) but has function call overhead
 * SC : O(n) for dp array + O(n) for recursion stack
 * Prone to TLE due to deep recursion
 *
 * Approach -2 : Tabulation
 * TC : O(n)
 * SC : O(n) for dp array
 * Fast and safe for large inputs
 *
 * Approach -3 : Memory efficient
 * TC : O(n)
 * SC : O(1)
 */

package DP;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = { 1,100 };

        int ans = minCostClimbingStairs(cost);
        System.out.println(ans);
    }

    public static int minCostClimbingStairs(int cost[]) {
        // Memoization
        int n = cost.length;
        int dp[] = new int[n + 1];
        int ans = memoization(n, dp, cost);
        System.out.println("Memoization " + ans);

        // Tabulation
        System.out.println("Tabulation " + tabulation(cost));

        return ans;
    }

    public static int memoization(int n, int dp[], int cost[]) {
        if(dp[n] != 0) return dp[n];
        if (n <= 1) return dp[n] = cost[n];
        return dp[n] = (n == cost.length ? 0 : cost[n]) + Math.min(memoization(n-1, dp, cost), memoization(n-2, dp, cost));
    }

    public static int tabulation(int cost[]) {
        int dp[] = new int[cost.length];

        for (int i = 0; i < cost.length; i++) {
            if (i <= 1) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }

        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
