package DP;

import java.util.Arrays;

public class FibonacciNumber {
    public static void main(String[] args) {
        int n = 5;

        int ans = fib(n);
        System.out.println(ans);
    }

    public static int fib(int n) {
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
        if(n<=1) return dp[n] = n;
        if(dp[n] != -1) return dp[n];
        return dp[n] = memoization(n-1, dp) + memoization(n-2, dp);
    }

    public static int tabulation(int n) {
        if(n<=1) return n;
        int dp[] = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    public static int memory_efficient(int n) {
        int prev1 = 0;
        int prev2 = 1;
        int curr = 0;
        for(int i=2; i<=n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }

        return n!= 0 ? prev2 : 0;
    }
}
